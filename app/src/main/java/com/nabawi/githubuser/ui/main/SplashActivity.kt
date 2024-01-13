package com.nabawi.githubuser.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.nabawi.githubuser.R

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.splash_image)

        // Memuat animasi dari file XML animasi
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Animasi dimulai
            }

            override fun onAnimationEnd(animation: Animation?) {
                // Handler untuk mengganti ke Activity utama setelah beberapa detik
                Handler().postDelayed({
                    val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }, splashTimeOut)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        splashImage.startAnimation(animation)
    }
}