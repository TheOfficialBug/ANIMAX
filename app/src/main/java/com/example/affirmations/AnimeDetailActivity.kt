package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AnimeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_detail)

        val animeImage = findViewById<ImageView>(R.id.animeImage)
        val animeTitle = findViewById<TextView>(R.id.animeTitle)
        val animeRating = findViewById<TextView>(R.id.animeRating)
        val animeDescription = findViewById<TextView>(R.id.animeDescription)
        val animeGenre = findViewById<TextView>(R.id.animeGenre)

        val extras = intent.extras

        if (extras != null){
            val title = extras.getInt("stringResourceId", 0)
            animeTitle.text = getString(title)

            val image = extras.getInt("imageResourceId", 0)
            animeImage.setImageDrawable(getDrawable(image))

            val rating = extras.getFloat("rating", 0f)
            animeRating.text = rating.toString()

            val description = extras.getString("description", "")
            animeDescription.text = description

            val genre = extras.getString("genre", "")
            animeGenre.text = genre

        }
    }
}