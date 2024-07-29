package com.collanquiandres.nutri

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage: ImageView = findViewById(R.id.splashImage)

        // Duración de la pantalla de inicio
        Handler(Looper.getMainLooper()).postDelayed({
            // Inicia la animación de salida
            val slideOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
            splashImage.startAnimation(slideOut)

            // Inicia la MainActivity después de la duración de la animación
            slideOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
                    finish() // Finaliza la SplashActivity
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }, 3000) // Duración en milisegundos
    }
}




