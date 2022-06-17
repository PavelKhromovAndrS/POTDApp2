package com.example.potdapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.example.potdapp2.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val img: ImageView = findViewById(R.id.image_view)

        img.animate().rotationBy(720f)
            .setInterpolator(LinearInterpolator()).duration = 10000

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
