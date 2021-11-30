package com.suonk.coyali_test_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.suonk.coyali_test_app.R
import com.suonk.coyali_test_app.databinding.FragmentListOfMoviesBinding
import com.suonk.coyali_test_app.ui.adapters.MoviesListAdapter
import com.suonk.coyali_test_app.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfMoviesFragment : BaseFragment() {

    private var binding: FragmentListOfMoviesBinding? = null

    private lateinit var movieListAdapter: MoviesListAdapter
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListAdapter = MoviesListAdapter(contextActivity) { id ->
            setMovieSelectedInViewModel(id)

            val navDir =
                ListOfMoviesFragmentDirections.actionListOfMoviesFragmentToMovieDetailFragment()
            navController.navigate(navDir)
        }

        binding?.addNewMovie?.setOnClickListener {
            viewModel.setMutableLiveDataMovie(null)

            val navDir =
                ListOfMoviesFragmentDirections.actionListOfMoviesFragmentToMovieDetailFragment()
            navController.navigate(navDir)
        }

        contextActivity.title = "Mes Films"

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding?.moviesRecyclerView?.apply {
            adapter = movieListAdapter
            getAllMoviesFromViewModel()
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(contextActivity)
        }
    }

    private fun getAllMoviesFromViewModel() {
        movieListAdapter.submitList(null)
        viewModel.allMovies.observe(viewLifecycleOwner, { movies ->
            movieListAdapter.submitList(movies)
        })
    }

    private fun setMovieSelectedInViewModel(id: Int) {
        viewModel.allMovies.observe(viewLifecycleOwner, { movies ->
            for (movie in movies) {
                if (movie.id == id) {
                    viewModel.setMutableLiveDataMovie(movie)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}