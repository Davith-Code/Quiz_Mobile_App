package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var getStartedButton: Button
    private lateinit var loginButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_start)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcome_start)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getStartedButton = findViewById(R.id.getStartedButton)
        loginButton = findViewById(R.id.loginButton)

        getStartedButton.setOnClickListener {
            val intent = Intent(this, welcome_page_1::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {

            val intent = Intent(this, welcome_page_1::class.java)
            startActivity(intent)
        }
    }
}