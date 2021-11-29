package com.suonk.coyali_test_app.models.dao

import androidx.room.*
import com.suonk.coyali_test_app.models.data.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    /**
     *  getAllMovies() = movie1, movie2, movie3....
     */
    @Query("SELECT * FROM movie ORDER BY title ASC")
    fun getAllMovies(): Flow<List<Movie>>

    /**
     *  insertMovie()
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    /**
     *  updateMovie()
     */
    @Update
    suspend fun updateMovie(movie: Movie)

    /**
     *  deleteMovie()
     */
    @Delete
    suspend fun deleteMovie(movie: Movie)
}