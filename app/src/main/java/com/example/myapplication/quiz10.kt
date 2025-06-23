package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quiz10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz10)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz10)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find your answer buttons and result banner
        val btnGlasses: Button = findViewById(R.id.btn_glasses)
        val btnCamera: Button = findViewById(R.id.btn_camera)
        val btnCoffee: Button = findViewById(R.id.btn_coffee)
        val btnNotebook: Button = findViewById(R.id.btn_notebook)
        val btnPencil: Button = findViewById(R.id.btn_pencil)
        val btnEraser: Button = findViewById(R.id.btn_eraser)
        val resultBanner: TextView = findViewById(R.id.result_banner)

        // Collect all buttons in a list for easy disable
        val allButtons = listOf(btnGlasses, btnCamera, btnCoffee, btnNotebook, btnPencil, btnEraser)

        // Set the correct answer here (example: Notebook)
        val correctButton = btnNotebook

        // Click handler for all answer buttons
        fun handleAnswer(selected: Button) {
            // Disable all answer buttons
            allButtons.forEach { it.isEnabled = false }

            if (selected == correctButton) {
                selected.setBackgroundColor(Color.parseColor("#4CAF50"))
                resultBanner.text = "Correct!"
                resultBanner.setBackgroundColor(Color.parseColor("#4CAF50"))
            } else {
                selected.setBackgroundColor(Color.parseColor("#F44336"))
                correctButton.setBackgroundColor(Color.parseColor("#4CAF50"))
                resultBanner.text = "Incorrect! The answer is ${correctButton.text}"
                resultBanner.setBackgroundColor(Color.parseColor("#F44336"))
            }
            resultBanner.visibility = TextView.VISIBLE

            // Auto-navigate to result after 1 second
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, quiz_result::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        }

        btnGlasses.setOnClickListener { handleAnswer(btnGlasses) }
        btnCamera.setOnClickListener { handleAnswer(btnCamera) }
        btnCoffee.setOnClickListener { handleAnswer(btnCoffee) }
        btnNotebook.setOnClickListener { handleAnswer(btnNotebook) }
        btnPencil.setOnClickListener { handleAnswer(btnPencil) }
        btnEraser.setOnClickListener { handleAnswer(btnEraser) }
    }
}
