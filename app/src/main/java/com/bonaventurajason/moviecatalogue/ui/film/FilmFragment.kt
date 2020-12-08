package com.bonaventurajason.moviecatalogue.ui.film

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bonaventurajason.moviecatalogue.databinding.FragmentFilmBinding
import com.bonaventurajason.moviecatalogue.ui.detail.DetailFilmActivity
import com.bonaventurajason.moviecatalogue.utils.Constant.ARG_POSITION
import com.bonaventurajason.moviecatalogue.utils.Constant.EXTRA_FILM_ID

class FilmFragment : Fragment() {
    private var _binding: FragmentFilmBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(position: Int): FilmFragment {
            val bundle = Bundle().apply {
                putInt(ARG_POSITION, position)
            }
            return FilmFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            arguments?.apply {
                val viewModel = ViewModelProvider(
                    this@FilmFragment,
                    ViewModelProvider.NewInstanceFactory()
                )[FilmViewModel::class.java]
                val filmAdapter = FilmAdapter()
                if (getInt(ARG_POSITION) == 0) {
                    val movies = viewModel.getMovies()
                    if (movies.isEmpty()) {
                        showEmptyState()
                    } else {
                        hideEmptyState()
                        filmAdapter.submitList(movies)
                    }

                } else {
                    val tvShows = viewModel.getTvShows()
                    if (tvShows.isEmpty()) {
                        showEmptyState()
                    } else {
                        hideEmptyState()
                        filmAdapter.submitList(tvShows)
                    }

                }
                binding.recyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                    adapter = filmAdapter
                }


                filmAdapter.setOnItemClickListener {
                    val intent = Intent(requireContext(), DetailFilmActivity::class.java).apply {
                        putExtra(EXTRA_FILM_ID, it)
                    }
                    startActivity(intent)
                }
            }

        }
    }

    private fun showEmptyState() {
        binding.recyclerView.visibility = View.GONE
        binding.textError.visibility = View.VISIBLE
    }

    private fun hideEmptyState() {
        binding.recyclerView.visibility = View.VISIBLE
        binding.textError.visibility = View.GONE
    }

}