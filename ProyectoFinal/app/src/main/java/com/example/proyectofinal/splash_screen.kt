package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContextCompat.startActivity

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        starTimer()
    }


    fun starTimer(){
        object: CountDownTimer(1000, 500){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(applicationContext,MainActivity::class.java).apply {  }
                startActivity(intent)
            }

        }.start()
    }
}