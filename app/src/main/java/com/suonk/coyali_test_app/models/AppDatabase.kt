package com.suonk.coyali_test_app.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.suonk.coyali_test_app.models.dao.MovieDao
import com.suonk.coyali_test_app.models.data.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}