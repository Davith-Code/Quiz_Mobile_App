package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.ImageView
import androidx.core.view.WindowInsetsCompat

class create_account_page_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_account_page2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val backArrow: ImageView = findViewById(R.id.backArrow)

        // Receive the extras
        val fullName = intent.getStringExtra("fullName")
        val dob = intent.getStringExtra("dob")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val age = intent.getStringExtra("age")

        // Example: You could pass these on to the next screen or use as needed

        // Go to next (success) page
        signUpButton.setOnClickListener {
            val successIntent = Intent(this, create_account_successful::class.java)
            // You could put extras again if needed:
            // successIntent.putExtra("fullName", fullName)
            startActivity(successIntent)
            finish()
        }

        // Back arrow to return to previous page (optional)
        backArrow.setOnClickListener {
            val successIntent = Intent(this, create_account_page_1::class.java)
            startActivity(successIntent)
            finish()
        }
    }

}