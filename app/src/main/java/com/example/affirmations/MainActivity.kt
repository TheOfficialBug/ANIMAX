package com.example.affirmations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Anime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().getAnimeList()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(this, myDataset)
        recyclerView.adapter = adapter

        val clickListener : ItemAdapter.ItemClickListener = object : ItemAdapter.ItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val anime = adapter.getAnime(position)

                launchDetailsActivity(anime)
            }
        }
        adapter.setItemClickListener(clickListener)

        recyclerView.setHasFixedSize(true)

    }
    private fun launchDetailsActivity(anime: Anime) {
        val intent = Intent(this, AnimeDetailActivity:: class.java)
        intent.putExtra("stringResourceId", anime.stringResourceId)
        intent.putExtra("imageResourceId", anime.imageResourceId)
        intent.putExtra("rating", anime.rating)
        intent.putExtra("description", anime.description)
        intent.putExtra("genre", anime.genre)
        startActivity(intent)
    }

}
