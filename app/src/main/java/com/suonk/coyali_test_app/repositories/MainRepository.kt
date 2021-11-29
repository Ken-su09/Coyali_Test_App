package com.suonk.coyali_test_app.repositories

import com.suonk.coyali_test_app.models.dao.MovieDao
import com.suonk.coyali_test_app.models.data.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val dao: MovieDao) : DefaultRepository {

    override fun getAllMovies() = dao.getAllMovies()

    override suspend fun insertMovie(movie: Movie) = dao.insertMovie(movie)

    override suspend fun updateMovie(movie: Movie) = dao.updateMovie(movie)

    override suspend fun deleteMovie(movie: Movie) = dao.deleteMovie(movie)
}