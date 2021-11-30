package com.suonk.coyali_test_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import com.suonk.coyali_test_app.R
import com.suonk.coyali_test_app.databinding.FragmentMovieDetailBinding
import com.suonk.coyali_test_app.models.data.Movie
import com.suonk.coyali_test_app.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment() {

    private var binding: FragmentMovieDetailBinding? = null
    private val viewModel: MovieViewModel by activityViewModels()

    private var newMovie = false
    private var movieNote = 0
    private var movieId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovieFromViewModel()
        binding?.apply {
            validateButton.setOnClickListener {
                validateClickListener()
            }
            cancelButton.setOnClickListener {
                cancelClickListener()
            }
            deleteButton.setOnClickListener {
                deleteClickListener()
            }

            ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
                movieNote = rating.toInt()
            }
        }
    }

    private fun getMovieFromViewModel() {
        viewModel.mutableLiveDataMovie.observe(viewLifecycleOwner, { movie ->
            if (movie != null) {
                contextActivity.title = "Mon Film"
                // Movie Detail
                binding?.apply {
                    movieTitleValue.setText(movie.title)
                    movieCommentValue.setText(movie.comment)
                    movieNote = movie.note
                    movieId = movie.id

                    ratingBar.rating = movieNote.toFloat()

                    deleteButton.visibility = View.VISIBLE
                    cancelButton.visibility = View.GONE
                }
            } else {
                contextActivity.title = "Nouveau Film"
                newMovie = true
            }
        })
    }

    //region =========================================== Listeners ==========================================

    private fun validateClickListener() {
        if (!checkIfFieldsEmpty()) {
            if (checkIfThereIsANote()) {
                if (newMovie) {
                    viewModel.insertMovie(
                        Movie(
                            binding?.movieTitleValue?.text.toString(),
                            binding?.movieCommentValue?.text.toString(),
                            movieNote
                        )
                    )
                    navController.popBackStack()
                } else {
                    viewModel.updateMovie(
                        Movie(
                            binding?.movieTitleValue?.text.toString(),
                            binding?.movieCommentValue?.text.toString(),
                            movieNote,
                            movieId
                        )
                    )
                    navController.popBackStack()
                }
            } else {
                Toast.makeText(
                    contextActivity,
                    "Vous devez ajouter une note au film",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                contextActivity,
                "Les champs ne doivent pas être vides",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun cancelClickListener() {
        navController.popBackStack()
    }

    private fun deleteClickListener() {
        viewModel.deleteMovie(
            Movie(
                binding?.movieTitleValue?.text.toString(),
                binding?.movieCommentValue?.text.toString(),
                movieNote,
                movieId
            )
        )
        navController.popBackStack()
    }

    //endregion

    //region ============================================ Check =============================================

    private fun checkIfFieldsEmpty(): Boolean {
        return binding?.movieTitleValue?.text?.isEmpty() == true || binding?.movieCommentValue?.text?.isEmpty() == true
    }

    private fun checkIfThereIsANote(): Boolean {
        return binding?.ratingBar?.rating?.toInt() != 0
    }

    //endregion

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}