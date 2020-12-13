package com.bonaventurajason.moviecatalogue.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.FilmEntity
import com.bonaventurajason.moviecatalogue.utils.Constant.EXTRA_FILM_ID
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_film.*

@AndroidEntryPoint
class DetailFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)
        setSupportActionBar(findViewById(R.id.toolbar))
        toolbar.setTitleTextColor(Color.WHITE)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailFilmViewModel::class.java)

        val extras = intent.extras
        if(extras != null){
            val filmId = extras.getString(EXTRA_FILM_ID)
            if(filmId != null){
                viewModel.setSelectedFilm(filmId)
                populateFilmDetail(viewModel.getFilm())
            }
        }
    }

    private fun populateFilmDetail(film: FilmEntity) {
        Glide.with(this)
            .load(film.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .centerCrop())
            .into(poster)
        description_value.text = film.description
        release_date_value.text = film.releaseDate
        genre_value.text = film.genre
        creator_value.text = film.creator
        supportActionBar?.title = film.title
        collapsing_toolbar.setCollapsedTitleTextColor(Color.WHITE)


    }
}