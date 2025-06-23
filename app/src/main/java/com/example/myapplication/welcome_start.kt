package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class welcome_start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_start)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, welcome_page_1::class.java))
            finish()
        }, 5000)
    }
}
