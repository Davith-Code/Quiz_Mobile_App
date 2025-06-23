package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class change_password_successful : AppCompatActivity() {
    private lateinit var goHomeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_password_successful)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.change_password_successful)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        goHomeButton = findViewById(R.id.goHomeButton)

        // 🔙 Go back
        goHomeButton.setOnClickListener {
            val intent = Intent(this, login_form::class.java)
            startActivity(intent)
            finish()
        }
    }
}