package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quiz1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnOption1: Button = findViewById(R.id.btn_option_1)
        val btnOption2: Button = findViewById(R.id.btn_option_2)
        val btnOption3: Button = findViewById(R.id.btn_option_3)
        val btnOption4: Button = findViewById(R.id.btn_option_4)
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        val allButtons = listOf(btnOption1, btnOption2, btnOption3, btnOption4)
        val correctButton = btnOption1 // or whichever is correct

        fun handleAnswer(selected: Button) {
            allButtons.forEach { it.isEnabled = false }

            if (selected == correctButton) {
                selected.setBackgroundColor(Color.parseColor("#4CAF50"))
                resultBanner.text = "Correct!"
                resultBanner.setBackgroundColor(Color.parseColor("#4CAF50"))
            } else {
                selected.setBackgroundColor(Color.parseColor("#F44336"))
                resultBanner.text = "Incorrect! That was close"
                resultBanner.setBackgroundColor(Color.parseColor("#F44336"))
                correctButton.setBackgroundColor(Color.parseColor("#4CAF50"))
            }
            resultBanner.visibility = TextView.VISIBLE
        }

        btnOption1.setOnClickListener { handleAnswer(btnOption1) }
        btnOption2.setOnClickListener { handleAnswer(btnOption2) }
        btnOption3.setOnClickListener { handleAnswer(btnOption3) }
        btnOption4.setOnClickListener { handleAnswer(btnOption4) }

        btnNext.setOnClickListener {
            val intent = Intent(this, quiz2::class.java) // Change to your actual next activity
            startActivity(intent)
            finish()
        }

    }
}
