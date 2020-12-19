package com.bonaventurajason.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {


    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }


    @Test
    fun loadDetailMovie(){
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date_value)).check(matches(isDisplayed()))
    }


    @Test
    fun loadDetailTVSHow(){
        onView(withText("TV Show")).perform(click())
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date_value)).check(matches(isDisplayed()))
    }

}