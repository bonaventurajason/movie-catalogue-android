package com.bonaventurajason.moviecatalogue.ui.favourite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bonaventurajason.moviecatalogue.databinding.FragmentFavouriteMovieBinding
import com.bonaventurajason.moviecatalogue.ui.detail.DetailFilmActivity
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bonaventurajason.moviecatalogue.utils.Constant.ARG_POSITION
import com.bonaventurajason.moviecatalogue.utils.Constant.FAVOURITE_FILM
import com.bonaventurajason.moviecatalogue.utils.Constant.IS_FROM_FAVOURITE
import com.bonaventurajason.moviecatalogue.utils.Constant.TYPE_OF_FILM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteMovieFragment : Fragment() {
    private var _binding: FragmentFavouriteMovieBinding? = null
    private val binding get() = _binding!!

    private lateinit var favouriteFilmAdapter: FavouriteFilmAdapter

    private val viewModel: FavouriteFilmViewModel by viewModels()



    companion object {
        fun newInstance(position: Int): FavouriteMovieFragment {
            val bundle = Bundle().apply {
                putInt(ARG_POSITION, position)
            }
            return FavouriteMovieFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        if(activity != null){
            arguments?.apply {

                if(getInt(ARG_POSITION) == 0){
                    viewModel.getFavouriteMovies().observe(viewLifecycleOwner, {
                        favouriteFilmAdapter.submitList(it)
                    })
                }
                else{
                    viewModel.getFavouriteTVShows().observe(viewLifecycleOwner, {
                        favouriteFilmAdapter.submitList(it)
                    })
                }

                favouriteFilmAdapter.setOnItemClickListener {
                    val typeOfFilm: String = if (arguments?.getInt(ARG_POSITION) == 0) {
                        Constant.MOVIE
                    } else {
                        Constant.TV_SHOW
                    }
                    val intent = Intent(requireContext(), DetailFilmActivity::class.java).apply {
                        putExtra(IS_FROM_FAVOURITE, true)
                        putExtra(TYPE_OF_FILM, typeOfFilm)
                        putExtra(FAVOURITE_FILM, it)
                    }
                    startActivity(intent)
                }
            }
        }

    }

    private fun setupRecyclerView() = binding.recyclerView.apply {
        layoutManager = LinearLayoutManager(requireContext())
        favouriteFilmAdapter = FavouriteFilmAdapter()
        adapter = favouriteFilmAdapter
    }

}