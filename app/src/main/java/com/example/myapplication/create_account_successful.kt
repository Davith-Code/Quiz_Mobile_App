package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class create_account_successful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account_successful)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_account_successful)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Delay for 2 seconds (2000 milliseconds), then go to home_page
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, home_page::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000ms = 2 seconds
    }
}
