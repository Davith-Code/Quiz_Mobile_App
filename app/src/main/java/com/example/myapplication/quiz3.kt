package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class quiz3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz3)

        val btnOption1: Button = findViewById(R.id.btn_option_1)
        val btnOption2: Button = findViewById(R.id.btn_option_2)
        val btnOption3: Button = findViewById(R.id.btn_option_3)
        val btnOption4: Button = findViewById(R.id.btn_option_4)
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        val allButtons = listOf(btnOption1, btnOption2, btnOption3, btnOption4)
        val correctButton = btnOption1 // "This is a Calendar"

        // Prepare for a fresh question
        fun resetUI() {
            allButtons.forEach {
                it.isEnabled = true
                it.setBackgroundColor(Color.TRANSPARENT) // Reset to default
            }
            resultBanner.visibility = TextView.GONE
            btnNext.isEnabled = false
            btnNext.alpha = 0.5f
        }

        resetUI()

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
                correctButton.setBackgroundColor(Color.parseColor("#4CAF50")) // Show correct
                resultBanner.text = "Incorrect! That was close"
                resultBanner.setBackgroundColor(Color.parseColor("#F44336"))
            }
            resultBanner.visibility = TextView.VISIBLE
        }

        btnOption1.setOnClickListener { handleAnswer(btnOption1) }
        btnOption2.setOnClickListener { handleAnswer(btnOption2) }
        btnOption3.setOnClickListener { handleAnswer(btnOption3) }
        btnOption4.setOnClickListener { handleAnswer(btnOption4) }

        btnNext.setOnClickListener {
            // Go to next quiz, e.g.,
            val intent = Intent(this, quiz4::class.java)
            startActivity(intent)
            finish()
        }
    }
}
