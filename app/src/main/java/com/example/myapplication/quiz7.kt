package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class quiz7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz7)

        val btnBook: Button = findViewById(R.id.button_book)
        val btnRule: Button = findViewById(R.id.button_rule)
        val btnLaptop: Button = findViewById(R.id.button_laptop)
        val btnScissors: Button = findViewById(R.id.button_scissors)
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        val allButtons = listOf(btnBook, btnRule, btnLaptop, btnScissors)

        // CHANGE THIS to your correct answer!
        val correctButton = btnLaptop

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

        btnBook.setOnClickListener { handleAnswer(btnBook) }
        btnRule.setOnClickListener { handleAnswer(btnRule) }
        btnLaptop.setOnClickListener { handleAnswer(btnLaptop) }
        btnScissors.setOnClickListener { handleAnswer(btnScissors) }

        btnNext.setOnClickListener {
            // Go to next quiz (quiz8)
            val intent = Intent(this, quiz8::class.java)
            startActivity(intent)
            finish()
        }
    }
}
