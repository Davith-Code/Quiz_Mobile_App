package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class quiz2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz2)
        val btnTrue: Button = findViewById(R.id.btn_true)
        val btnFalse: Button = findViewById(R.id.btn_false)
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)
        val allButtons = listOf(btnTrue, btnFalse)

        btnNext.isEnabled = false
        btnNext.alpha = 0.5f

        fun handleAnswer(isTrue: Boolean) {
            allButtons.forEach { it.isEnabled = false }
            btnNext.isEnabled = true
            btnNext.alpha = 1.0f

            if (isTrue) {
                btnTrue.setBackgroundColor(Color.parseColor("#4CAF50"))
                resultBanner.text = "Correct!"
                resultBanner.setBackgroundColor(Color.parseColor("#4CAF50"))
            } else {
                btnFalse.setBackgroundColor(Color.parseColor("#F44336"))
                resultBanner.text = "Incorrect!"
                resultBanner.setBackgroundColor(Color.parseColor("#F44336"))
                btnTrue.setBackgroundColor(Color.parseColor("#4CAF50"))
            }
            resultBanner.visibility = TextView.VISIBLE
        }

        btnTrue.setOnClickListener { handleAnswer(true) }
        btnFalse.setOnClickListener { handleAnswer(false) }

        btnNext.setOnClickListener {
            val intent = Intent(this, quiz3::class.java)
             startActivity(intent)
            finish()
        }
    }
}
