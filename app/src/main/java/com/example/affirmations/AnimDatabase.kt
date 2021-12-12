package com.example.affirmations

import android.content.Context
import android.content.res.AssetManager
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.affirmations.data.Anime
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Anime::class], version = 1, exportSchema = false)
abstract class AnimDatabase : RoomDatabase(){
    abstract val animeDao : AnimeDao

    companion object{
        val executor:ExecutorService = Executors.newSingleThreadExecutor()

        @Volatile
        private var Instance : AnimDatabase ?= null

        fun getInstance(context: Context):AnimDatabase{
            synchronized(this){
                var instance : AnimDatabase ?= Instance
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AnimDatabase::class.java,
                        "AnimeDatabase"
                    ).fallbackToDestructiveMigration().build()
                    Instance = instance
                }
                return instance
            }
        }
        fun parseJson(assetManager: AssetManager) : MutableList<com.example.affirmations.data.Anime>{
            var jsonString : String ?= null
            val animeList : MutableList<com.example.affirmations.data.Anime> = mutableListOf()
            try {
                jsonString = assetManager.open("animeList.json").bufferedReader().use {
                    it.readText()
                }
            }
            catch (ioException : IOException) {
                ioException.printStackTrace()
            }
            if (jsonString != null) {
                try {
                    val rootObject : JSONObject = JSONObject(jsonString)
                    val animeJsonArray : JSONArray = rootObject.getJSONArray("Anime")
                    for (i in 0 until animeJsonArray.length()) {
                        val animeObject : JSONObject = animeJsonArray.getJSONObject(i)
                        val animeTitle : String = animeObject.getString("title")
                        val animeRating : String = animeObject.getString("rating")
                        val animeDescription : String = animeObject.getString("description")
                        val animeGenre : String = animeObject.getString("genre")
                        val animeImage : String = animeObject.getString("image")

                        val anime : com.example.affirmations.data.Anime = com.example.affirmations.data.Anime(animeTitle, animeImage, animeRating, animeDescription, animeGenre)
                        animeList.add(anime)
                    }
                }catch (jsonException : JSONException){
                    jsonException.printStackTrace()
                }
            }
            return animeList
        }
    }
}