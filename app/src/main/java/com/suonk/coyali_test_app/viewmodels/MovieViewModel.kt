package com.suonk.coyali_test_app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.suonk.coyali_test_app.models.data.Movie
import com.suonk.coyali_test_app.repositories.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: DefaultRepository) : ViewModel() {

    val allMovies = repository.getAllMovies().asLiveData()

    fun insertMovie(movie: Movie) = viewModelScope.launch {
        repository.insertMovie(movie)
    }

    fun updateMovie(movie: Movie) = viewModelScope.launch {
        repository.updateMovie(movie)
    }

    fun deleteMovie(movie: Movie) = viewModelScope.launch {
        repository.deleteMovie(movie)
    }

    var mutableLiveDataMovie = MutableLiveData<Movie?>()
    fun setMutableLiveDataMovie(movie: Movie?) {
        mutableLiveDataMovie.postValue(movie)
    }
}