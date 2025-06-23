package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class create_quiz_2 : AppCompatActivity() {

    companion object {
        private const val REQ_EDIT_POINT = 101
        private const val REQ_TIME_LIMIT = 102
        private const val REQ_ADD_IMAGE = 103
        private const val REQ_QUIZ3 = 104
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_quiz2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_quiz_2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Top bar
        val closeIcon = findViewById<ImageView>(R.id.closeIcon)
        val listIcon = findViewById<ImageView>(R.id.listIcon)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)

        // Cover image
        val addCoverImage = findViewById<ImageView>(R.id.addCoverImage)

        // Quiz settings
        val btnTimeLimit = findViewById<Button>(R.id.btn_time_limit)
        val btnPoints = findViewById<Button>(R.id.pointsButton)
        val spinnerQuizType = findViewById<Spinner>(R.id.quizTypeSpinner)

        // Add question card + text view inside it
        val addQuestionCard = findViewById<androidx.cardview.widget.CardView>(R.id.addQuestionCard)
        val questionTextView = findViewById<TextView>(R.id.questionTextView)

        // Answer buttons (MaterialButton)
        val answerButton1 = findViewById<MaterialButton>(R.id.answerButton1)
        val answerButton2 = findViewById<MaterialButton>(R.id.answerButton2)
        val answerButton3 = findViewById<MaterialButton>(R.id.answerButton3)
        val answerButton4 = findViewById<MaterialButton>(R.id.answerButton4)

        // Bottom bar
        val numberedInput = findViewById<EditText>(R.id.numberedInput)
        val addButton = findViewById<ImageButton>(R.id.addButton)

        // Spinner
        val quizTypes = arrayOf("Multiple Choice", "True/False", "Short Answer")
        spinnerQuizType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quizTypes)

        // Button Listeners
        closeIcon.setOnClickListener { finish() }
        listIcon.setOnClickListener { Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show() }
        addCoverImage.setOnClickListener {
            val intent = Intent(this, add_image::class.java)
            startActivityForResult(intent, REQ_ADD_IMAGE)
        }
        addButton.setOnClickListener {
            val intent = Intent(this, create_quiz_3::class.java)
            startActivityForResult(intent, REQ_QUIZ3)
        }
        btnTimeLimit.setOnClickListener {
            val intent = Intent(this, time_limit::class.java)
            startActivityForResult(intent, REQ_TIME_LIMIT)
        }
        btnPoints.setOnClickListener {
            val intent = Intent(this, edit_point::class.java)
            startActivityForResult(intent, REQ_EDIT_POINT)
        }

        spinnerQuizType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                // Use quizType if needed
                val quizType = quizTypes[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // -- EDITING QUESTION --
        addQuestionCard.setOnClickListener {
            showEditDialog(
                title = "Enter Question",
                currentText = questionTextView.text.toString(),
                onSubmit = { newText ->
                    questionTextView.text = newText
                }
            )
        }

        // -- EDITING ANSWERS --
        answerButton1.setOnClickListener {
            showEditDialog(
                title = "Edit Answer 1",
                currentText = answerButton1.text.toString(),
                onSubmit = { newText -> answerButton1.text = newText }
            )
        }
        answerButton2.setOnClickListener {
            showEditDialog(
                title = "Edit Answer 2",
                currentText = answerButton2.text.toString(),
                onSubmit = { newText -> answerButton2.text = newText }
            )
        }
        answerButton3.setOnClickListener {
            showEditDialog(
                title = "Edit Answer 3",
                currentText = answerButton3.text.toString(),
                onSubmit = { newText -> answerButton3.text = newText }
            )
        }
        answerButton4.setOnClickListener {
            showEditDialog(
                title = "Edit Answer 4",
                currentText = answerButton4.text.toString(),
                onSubmit = { newText -> answerButton4.text = newText }
            )
        }
    }

    // --- HANDLE ACTIVITY RESULTS ---
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                REQ_EDIT_POINT -> {
                    val selectedPoints = data.getStringExtra("SELECTED_POINTS")
                    if (!selectedPoints.isNullOrEmpty()) {
                        val btnPoints = findViewById<Button>(R.id.pointsButton)
                        btnPoints.text = selectedPoints
                    }
                }
                REQ_TIME_LIMIT -> {
                    val selectedTime = data.getStringExtra("SELECTED_TIME")
                    if (!selectedTime.isNullOrEmpty()) {
                        val btnTimeLimit = findViewById<Button>(R.id.btn_time_limit)
                        btnTimeLimit.text = selectedTime
                    }
                }
                REQ_ADD_IMAGE -> {
                    val imageResId = data.getIntExtra("SELECTED_IMAGE_RES", -1)
                    if (imageResId != -1) {
                        val addCoverImage = findViewById<ImageView>(R.id.addCoverImage)
                        addCoverImage.setImageResource(imageResId)
                    }
                }
                // Optionally, handle REQ_QUIZ3 if you want
            }
        }
    }

    // --- DIALOG FOR EDITING QUESTIONS/ANSWERS ---
    private fun showEditDialog(title: String, currentText: String, onSubmit: (String) -> Unit) {
        val editText = EditText(this)
        editText.setText(currentText)
        editText.setSelection(editText.text.length)
        AlertDialog.Builder(this)
            .setTitle(title)
            .setView(editText)
            .setPositiveButton("OK") { dialog, _ ->
                onSubmit(editText.text.toString())
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
