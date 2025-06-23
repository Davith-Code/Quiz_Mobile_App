package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class welcome_page_1 : AppCompatActivity() {

    private lateinit var getStartedButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page1)

        // Initialize buttons
        getStartedButton = findViewById(R.id.getStartedButton)
        loginButton = findViewById(R.id.loginButton)

        // Set click listener for GET STARTED button to navigate to page 2
        getStartedButton.setOnClickListener {
            val intent = Intent(this, welcome_page_2::class.java)
            startActivity(intent)
        }

        // Set click listener for login button to navigate to page 2
        loginButton.setOnClickListener {
            val intent = Intent(this, login_form::class.java)
            startActivity(intent)
        }
    }
}