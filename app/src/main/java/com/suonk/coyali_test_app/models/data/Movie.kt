package com.suonk.coyali_test_app.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "comment")
    val comment: String,
    @ColumnInfo(name = "note")
    val note: Int,
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
