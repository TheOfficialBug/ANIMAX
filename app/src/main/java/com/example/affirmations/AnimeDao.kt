package com.example.affirmations

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.affirmations.data.Anime

@Dao
interface AnimeDao {

    @Insert
    fun insertAnime(anime: Anime)

    @Update
    fun updateAnime(anime: Anime)

    @Delete
    fun deleteAnime(anime: Anime)

    @Query("SELECT * FROM Anime")
    fun getAllAnime(): LiveData<Anime>

}