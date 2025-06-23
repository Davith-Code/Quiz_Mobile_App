package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class quiz6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz6)

        val btnOption1: Button = findViewById(R.id.btn_option_1) // "2"
        val btnOption2: Button = findViewById(R.id.btn_option_2) // "5"
        val btnOption3: Button = findViewById(R.id.btn_option_3) // "6"
        val btnOption4: Button = findViewById(R.id.btn_option_4) // "4"
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        // SET the correct button here:
        val correctButton = btnOption4 // Change to btnOptionX based on the correct answer. For example, if "4" pens is correct.

        val allButtons = listOf(btnOption1, btnOption2, btnOption3, btnOption4)
        btnNext.isEnabled = false
        btnNext.alpha = 0.5f

        fun handleAnswer(selected: Button) {
            allButtons.forEach { it.isEnabled = false }
            btnNext.isEnabled = true
            btnNext.alpha = 1.0f

            if (selected == correctButton) {
                selected.setBackgroundColor(Color.parseColor("#4CAF50")) // Green
                resultBanner.text = "Correct!"
                resultBanner.setBackgroundColor(Color.parseColor("#4CAF50"))
            } else {
                selected.setBackgroundColor(Color.parseColor("#F44336")) // Red
                correctButton.setBackgroundColor(Color.parseColor("#4CAF50"))
                resultBanner.text = "Incorrect! The answer is ${correctButton.text}"
                resultBanner.setBackgroundColor(Color.parseColor("#F44336"))
            }
            resultBanner.visibility = TextView.VISIBLE
        }

        btnOption1.setOnClickListener { handleAnswer(btnOption1) }
        btnOption2.setOnClickListener { handleAnswer(btnOption2) }
        btnOption3.setOnClickListener { handleAnswer(btnOption3) }
        btnOption4.setOnClickListener { handleAnswer(btnOption4) }

        btnNext.setOnClickListener {
            // Go to next quiz (quiz7)
            val intent = Intent(this, quiz7::class.java)
            startActivity(intent)
            finish()
        }
    }
}
