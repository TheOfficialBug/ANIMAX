package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Anime(
        @StringRes val stringResourceId: Int,
        @DrawableRes val imageResourceId: Int,
        val rating : Float,
        val description : String,
        val genre : String
)