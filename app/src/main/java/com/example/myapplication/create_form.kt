package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class create_form : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_form)

        // Initialize buttons and layouts
        val backButton: ImageView = findViewById(R.id.backButton)
        val skipButton: Button = findViewById(R.id.skipButton)

        val personalButton: LinearLayout = findViewById(R.id.personal)
        val teacherButton: LinearLayout = findViewById(R.id.teacher)
        val studentButton: LinearLayout = findViewById(R.id.student)
        val professionalButton: LinearLayout = findViewById(R.id.professional)

        // Apply system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_form)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔙 Go back
        backButton.setOnClickListener {
            val intent = Intent(this, welcome_page_1::class.java)
            startActivity(intent)
            finish()
        }

        // ⏩ Skip to next form
        skipButton.setOnClickListener {
            val intent = Intent(this, home_page::class.java) // Replace with your actual next form activity
            startActivity(intent)
            finish()
        }

        // Set click listeners for the different account types
        personalButton.setOnClickListener {
            // Navigate to the Personal form
            val intent = Intent(this, create_account_page_1::class.java)  // Replace with the actual PersonalForm activity
            startActivity(intent)
        }

        teacherButton.setOnClickListener {
            // Navigate to the Teacher form
            val intent = Intent(this, create_account_page_1::class.java)  // Replace with the actual TeacherForm activity
            startActivity(intent)
        }

        studentButton.setOnClickListener {
            // Navigate to the Student form
            val intent = Intent(this, create_account_page_1::class.java)  // Replace with the actual StudentForm activity
            startActivity(intent)
        }

        professionalButton.setOnClickListener {
            // Navigate to the Professional form
            val intent = Intent(this, create_account_page_1::class.java)  // Replace with the actual ProfessionalForm activity
            startActivity(intent)
        }
    }
}
