package com.suonk.coyali_test_app.repositories

import com.suonk.coyali_test_app.models.data.Movie
import kotlinx.coroutines.flow.Flow

interface DefaultRepository {

    fun getAllMovies(): Flow<List<Movie>>

    suspend fun insertMovie(movie: Movie)
    suspend fun updateMovie(movie: Movie)
    suspend fun deleteMovie(movie: Movie)
}