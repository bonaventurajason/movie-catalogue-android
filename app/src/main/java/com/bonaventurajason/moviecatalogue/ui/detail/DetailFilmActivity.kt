package com.bonaventurajason.moviecatalogue.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bonaventurajason.moviecatalogue.utils.Constant.EXTRA_FILM_ID
import com.bonaventurajason.moviecatalogue.utils.Constant.TYPE_OF_FILM
import com.bonaventurajason.moviecatalogue.utils.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailFilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFilmBinding
    private val viewModel: DetailFilmViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbar.setTitleTextColor(Color.WHITE)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if(extras != null){
            val filmId = extras.getInt(EXTRA_FILM_ID)
            val typeOfFilm = extras.getString(TYPE_OF_FILM)

            if (typeOfFilm != null) {
                viewModel.getDetailFilm(typeOfFilm, filmId)
                observeDetailFilm(filmId, typeOfFilm)
            }
        }
    }

    private fun observeDetailFilm(filmId: Int, typeOfFilm: String) {
        viewModel.detailFilm.observe(this, {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS  -> {
                        hideProgressBar()
                        result.data?.let { detailFilmResponse ->
                            Timber.d("Detail film $detailFilmResponse")
                            populateFilmDetail(detailFilmResponse)
                        }
                    }
                    Status.ERROR -> {
                        hideProgressBar()
                        showErrorDialog(result.message, filmId, typeOfFilm)
                    }
                    Status.LOADING -> {
                        showProgressBar()
                    }
                }
            }

        })
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun populateFilmDetail(detailFilmResponse: DetailFilmResponse) {
        Glide.with(this)
            .load(Constant.IMAGE_URL+detailFilmResponse.backdropPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .centerCrop())
            .into(binding.backdrop)
        binding.descriptionValue.text = detailFilmResponse.overview
        binding.releaseDateValue.text = detailFilmResponse.releaseDate
        binding.tagline.text = detailFilmResponse.tagline
        binding.rating.text = detailFilmResponse.voteAverage.toString()
        binding.genre.text = detailFilmResponse.genres!!.joinToString {
            it.name
        }
        binding.originalLanguageValue.text = detailFilmResponse.originalLanguage
        binding.collapsingToolbar.title = detailFilmResponse.title
        binding.collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)

        Glide.with(this)
            .load(Constant.IMAGE_URL+detailFilmResponse.posterPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .fitCenter())
            .into(binding.posterValue)

    }

    private fun showErrorDialog(msg: String?, id: Int, typeOfFilm: String) {

        val msgError = if (msg == Constant.NO_INTERNET) {
            getString(R.string.network_error)
        } else {
            getString(R.string.other_error)
        }
        MaterialAlertDialogBuilder(this)
            .setTitle(msg)
            .setMessage(msgError)
            .setCancelable(false)
            .setPositiveButton(getString(R.string.retry)) { dialog, which ->

//                viewModel.refreshGetDetailFilm(typeOfFilm, id)
                dialog.dismiss()
            }
            .show()
    }
}