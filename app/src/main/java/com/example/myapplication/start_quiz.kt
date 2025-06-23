package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class start_quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.start_quiz)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backArrow: ImageView = findViewById(R.id.backArrow)
        val btnPlaySolo: Button = findViewById(R.id.btnPlaySolo)
        val btnPlayWithFriends: Button = findViewById(R.id.btnPlayWithFriends)

        backArrow.setOnClickListener {
            val successIntent = Intent(this, home_page::class.java)
            startActivity(successIntent)
            finish()
        }

        btnPlaySolo.setOnClickListener {
            val intent = Intent(this, quiz1::class.java) // Change to your solo activity
            startActivity(intent)
        }

        btnPlayWithFriends.setOnClickListener {
            val intent = Intent(this, invite_and_scan::class.java) // Change to your friends activity
            startActivity(intent)
        }
    }
}
