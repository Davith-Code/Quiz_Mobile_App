package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class quiz9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz9)

        val btnTraveling: MaterialButton = findViewById(R.id.btn_traveling)
        val btnPainting: MaterialButton = findViewById(R.id.btn_painting)
        val btnDancing: MaterialButton = findViewById(R.id.btn_dancing)
        val btnSigning: MaterialButton = findViewById(R.id.btn_signing)
        val btnWriting: MaterialButton = findViewById(R.id.btn_writing)
        val btnOther: MaterialButton = findViewById(R.id.btn_other)
        val resultBanner: TextView = findViewById(R.id.result_banner)
        val btnNext: Button = findViewById(R.id.btn_next)

        val allButtons = listOf(btnTraveling, btnPainting, btnDancing, btnSigning, btnWriting, btnOther)

        // Set your correct answer button here
        val correctButton = btnTraveling // e.g., "Reading" is correct

        btnNext.isEnabled = false
        btnNext.alpha = 0.5f

        fun handleAnswer(selected: MaterialButton) {
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

        btnTraveling.setOnClickListener { handleAnswer(btnTraveling) }
        btnPainting.setOnClickListener { handleAnswer(btnPainting) }
        btnDancing.setOnClickListener { handleAnswer(btnDancing) }
        btnSigning.setOnClickListener { handleAnswer(btnSigning) }
        btnWriting.setOnClickListener { handleAnswer(btnWriting) }
        btnOther.setOnClickListener { handleAnswer(btnOther) }

        btnNext.setOnClickListener {
            // Go to quiz10 or finish
            val intent = Intent(this, quiz10::class.java)
            startActivity(intent)
            finish()
        }
    }
}
