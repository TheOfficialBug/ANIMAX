package com.example.affirmations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView

class AnimatedSplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_splash_screen)

        val bgImg : ImageView = findViewById(R.id.logo)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        bgImg.startAnimation(slideAnimation)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}