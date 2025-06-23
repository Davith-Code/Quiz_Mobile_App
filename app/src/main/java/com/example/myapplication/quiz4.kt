package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class quiz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz4)

        val imgQuestion = findViewById<ImageView>(R.id.image_question)
        val txtQuestion = findViewById<TextView>(R.id.text_question)
        val edtAnswer = findViewById<EditText>(R.id.answer_input)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val banner = findViewById<TextView>(R.id.result_banner)
        val txtProgress = findViewById<TextView>(R.id.text_progress)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val progressValue = findViewById<TextView>(R.id.progress_value)

        // Only one question for this activity
        imgQuestion.setImageResource(R.drawable.piggybank)
        txtQuestion.text = "What does the illustration above describe?"
        txtProgress.text = "4/10"
        progressBar.progress = 40
        progressValue.text = "40"
        edtAnswer.text.clear()
        banner.visibility = TextView.GONE
        btnNext.text = "Check"
        btnNext.isEnabled = true
        btnNext.alpha = 1f

        val correctAnswer = "Saving"

        btnNext.setOnClickListener {
            val answer = edtAnswer.text.toString().trim()
            if (btnNext.text == "Check") {
                // Check the answer
                if (answer.equals(correctAnswer, ignoreCase = true)) {
                    banner.text = "Correct!"
                    banner.setBackgroundColor(Color.parseColor("#4CAF50"))
                } else {
                    banner.text = "Incorrect! The answer is: $correctAnswer"
                    banner.setBackgroundColor(Color.parseColor("#F44336"))
                }
                banner.visibility = TextView.VISIBLE
                btnNext.text = "Next"
            } else {
                // Go to quiz5
                val intent = Intent(this, quiz5::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
