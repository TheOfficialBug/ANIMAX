package com.example.affirmations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Anime")
data class Anime (

    @ColumnInfo(name = "animeName")
    var animeName : String,

    @PrimaryKey(autoGenerate = true)
    var animeId : Long = 0L
)