package com.bonaventurajason.moviecatalogue.ui.film

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.databinding.FragmentFilmBinding
import com.bonaventurajason.moviecatalogue.ui.detail.DetailFilmActivity
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bonaventurajason.moviecatalogue.utils.Constant.ARG_POSITION
import com.bonaventurajason.moviecatalogue.utils.Constant.EXTRA_FILM_ID
import com.bonaventurajason.moviecatalogue.utils.Resource
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FilmFragment : Fragment() {
    private var _binding: FragmentFilmBinding? = null
    private val binding get() = _binding!!

    private lateinit var filmAdapter: FilmAdapter

    private val viewModel by viewModels<FilmViewModel>()

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
    ): View {
        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()



        if (activity != null) {
            arguments?.apply {

                if (getInt(ARG_POSITION) == 0) {
                    viewModel.getMovies()
                    observeMovies()
                } else {
                    viewModel.getTvShows()
                    observeTVShows()
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

    private fun observeTVShows() {
        viewModel.tvShows.observe(viewLifecycleOwner, { response ->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let { publicReportResponse ->
                        Timber.d("Data tv show ${publicReportResponse.results}")
                        if(publicReportResponse.results.isNullOrEmpty()){
                            showEmptyState()
                        }
                        else{
                            hideEmptyState()
                            filmAdapter.submitList(publicReportResponse.results)
                        }
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    showErrorDialog(response.message)
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, { response ->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let { publicReportResponse ->
                        if(publicReportResponse.results.isNullOrEmpty()){
                            showEmptyState()
                        }
                        else{
                            hideEmptyState()
                            filmAdapter.submitList(publicReportResponse.results)
                        }
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    showErrorDialog(response.message)
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun setupRecyclerView() = binding.recyclerView.apply {
        layoutManager = LinearLayoutManager(requireContext())
        filmAdapter = FilmAdapter()
        adapter = filmAdapter
    }

    private fun showEmptyState() {
        binding.recyclerView.visibility = View.GONE
        binding.textError.visibility = View.VISIBLE
    }

    private fun hideEmptyState() {
        binding.recyclerView.visibility = View.VISIBLE
        binding.textError.visibility = View.GONE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showErrorDialog(msg : String?) {

        val msgError = if(msg == Constant.NO_INTERNET){
            getString(R.string.network_error)
        }
        else{
            getString(R.string.other_error)
        }
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(msg)
            .setMessage(msgError)
            .setCancelable(false)
            .setPositiveButton(getString(R.string.retry)) { dialog, which ->

                viewModel.refreshGetAllMovies()
                dialog.dismiss()
            }
            .show()
    }

}