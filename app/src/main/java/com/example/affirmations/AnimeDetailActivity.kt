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
            val title = extras.getString("title", "")
            animeTitle.text = title

            val imageId = when(title) {
                "Naruto" -> R.drawable.naruto
                "Attack On Titan" -> R.drawable.aot
                "Darling In The Franxx" -> R.drawable.ditf
                "Death Note" -> R.drawable.dn
                "Dragon Ball Z" -> R.drawable.dragon
                "Erased" -> R.drawable.erased
                "Fullmetal Alchemist: Brotherhood" -> R.drawable.fullmetal
                "Tokyo Ghoul" -> R.drawable.ghoul
                "Haikyuu!" -> R.drawable.haikyuu
                "Horimiya" -> R.drawable.horimiya
                "Idaten Jump" -> R.drawable.idaten
                "Jujutsu Kaisen" -> R.drawable.jjk
                "One Piece" -> R.drawable.op
                "Naruto Shippuden" -> R.drawable.shippuden
                "Tokyo Revengers" -> R.drawable.tokyo

                else -> R.drawable.animax_logo
            }
            animeImage.setImageResource(imageId)

            val rating = extras.getString("rating", "")
            animeRating.text = rating.toString()

            val description = extras.getString("description", "")
            animeDescription.text = description

            val genre = extras.getString("genre", "")
            animeGenre.text = genre

        }
    }
}