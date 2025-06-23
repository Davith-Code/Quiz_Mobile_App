package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class quiz8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz8)

        val btnOption1: Button = findViewById(R.id.btn_option_1) // "Dog"
        val btnOption2: Button = findViewById(R.id.btn_option_2) // "Car"
        val btnOption3: Button = findViewById(R.id.btn_option_3) // "Egg"
        val btnOption4: Button = findViewById(R.id.btn_option_4) // "Fan"
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        val allButtons = listOf(btnOption1, btnOption2, btnOption3, btnOption4)
        val correctButton = btnOption1 // "Dog" is correct

        btnNext.isEnabled = false
        btnNext.alpha = 0.5f

        fun handleAnswer(selected: Button) {
            allButtons.forEach { it.isEnabled = false }
            btnNext.isEnabled = true
            btnNext.alpha = 1.0f

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
        }

        btnOption1.setOnClickListener { handleAnswer(btnOption1) }
        btnOption2.setOnClickListener { handleAnswer(btnOption2) }
        btnOption3.setOnClickListener { handleAnswer(btnOption3) }
        btnOption4.setOnClickListener { handleAnswer(btnOption4) }

        btnNext.setOnClickListener {
            // Go to next quiz (quiz9)
            val intent = Intent(this, quiz9::class.java)
            startActivity(intent)
            finish()
        }
    }
}
