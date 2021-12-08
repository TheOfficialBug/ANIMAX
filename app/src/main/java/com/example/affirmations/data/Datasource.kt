package com.example.affirmations.data

import android.content.Context
import android.content.res.AssetManager
import com.example.affirmations.R
import com.example.affirmations.model.Anime
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.security.AccessControlContext
import java.util.concurrent.*

class Datasource() {

    val executor : ExecutorService = Executors.newSingleThreadExecutor()
    fun getAnimeList(): List<Anime> {
            val genres : String = "Action"

            return listOf<Anime>(
                Anime(R.string.affirmation1, R.drawable.naruto, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation2, R.drawable.aot, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation3, R.drawable.ditf, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation4, R.drawable.dn, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation5, R.drawable.dragon , 4.5f, "Sample description", genres),
                Anime(R.string.affirmation6, R.drawable.erased, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation7, R.drawable.fullmetal, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation8, R.drawable.ghoul, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation9, R.drawable.haikyuu, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation10, R.drawable.horimiya, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation11, R.drawable.idaten, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation12, R.drawable.jjk, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation13, R.drawable.op, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation14, R.drawable.shippuden, 4.5f, "Sample description", genres),
                Anime(R.string.affirmation15, R.drawable.tokyo, 4.5f, "Sample description", genres))
    }

    fun getAnimeListFromJsonFile(context: Context) : Future<List<com.example.affirmations.data.Anime>> ? {
        val callable : Callable<List<com.example.affirmations.data.Anime>> = Callable {
            return@Callable parseJson(context.assets)
        }
        return executor.submit(callable)
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

