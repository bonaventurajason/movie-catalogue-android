package com.bonaventurajason.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.utils.DataDummy
import org.hamcrest.core.AllOf.allOf
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTVShow()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies(){
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.description_value)).check(matches(withText(dummyMovies[0].description)))
        onView(withId(R.id.release_date_value)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date_value)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.genre_value)).check(matches(isDisplayed()))
        onView(withId(R.id.genre_value)).check(matches(withText(dummyMovies[0].genre)))
    }

    @Test
    fun loadTVShow(){
        onView(withText("TV Show")).perform(click())
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTVSHow(){
        onView(withText("TV Show")).perform(click())
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.description_value)).check(matches(withText(dummyTvShows[0].description)))
        onView(withId(R.id.release_date_value)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date_value)).check(matches(withText(dummyTvShows[0].releaseDate)))
        onView(withId(R.id.genre_value)).check(matches(isDisplayed()))
        onView(withId(R.id.genre_value)).check(matches(withText(dummyTvShows[0].genre)))
    }

}