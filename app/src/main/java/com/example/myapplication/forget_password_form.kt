package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class forget_password_form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password_form)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.forget_password_form)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton: ImageView = findViewById(R.id.backButton)
        val continueButton: Button = findViewById(R.id.continueButton)

        // Go back to login
        backButton.setOnClickListener {
            val intent = Intent(this, login_form::class.java)
            startActivity(intent)
            finish()
        }

        // Go to next step of forgot password
        continueButton.setOnClickListener {
            val intent = Intent(this, forget_password_form2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
