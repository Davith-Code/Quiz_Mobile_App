package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView

class add_question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        // Window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.add_question)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar close button logic
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish() // or navigate to home_page
        }

        // Quiz Card click
        val cardQuiz = findViewById<MaterialCardView>(R.id.card_quiz)
        cardQuiz.setOnClickListener {
            val intent = Intent(this, create_quiz_2::class.java)
            startActivity(intent)
        }

        // True/False Card click
        val cardTrueOrFalse = findViewById<MaterialCardView>(R.id.card_true_or_false)
        cardTrueOrFalse.setOnClickListener {
            val intent = Intent(this, create_quiz_2::class.java)
            startActivity(intent)
        }

        // Puzzle Card click (add similar logic for others as needed)
        val cardPuzzle = findViewById<MaterialCardView>(R.id.card_puzzle)
        cardPuzzle.setOnClickListener {
            val intent = Intent(this, create_quiz_2::class.java)
            startActivity(intent)
        }

        // Type Answer Card click
        val cardTypeAnswer = findViewById<MaterialCardView>(R.id.card_type_answer)
        cardTypeAnswer.setOnClickListener {
            val intent = Intent(this, create_quiz_2::class.java)
            startActivity(intent)
        }

    }
}
