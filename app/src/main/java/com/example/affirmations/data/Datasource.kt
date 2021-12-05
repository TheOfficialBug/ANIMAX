package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Anime

class Datasource() {

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
}

