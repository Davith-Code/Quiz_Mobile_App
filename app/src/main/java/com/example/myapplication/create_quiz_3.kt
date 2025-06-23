package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class create_quiz_3 : AppCompatActivity() {

    private lateinit var timeButton: Button
    private lateinit var pointsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quiz3)

        // Find all views
        val closeIcon = findViewById<ImageView>(R.id.closeIcon)
        val listIcon = findViewById<ImageView>(R.id.listIcon)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val quizImage = findViewById<ImageView>(R.id.quizImage)
        timeButton = findViewById<Button>(R.id.timeButton)
        pointsButton = findViewById<Button>(R.id.pointsButton)
        val quizTypeSpinner = findViewById<Spinner>(R.id.quizTypeSpinner)
        val questionInput = findViewById<EditText>(R.id.questionInput)
        val answerButton1 = findViewById<Button>(R.id.answerButton1)
        val answerButton2 = findViewById<Button>(R.id.answerButton2)
        val answerButton3 = findViewById<Button>(R.id.answerButton3)
        val answerButton4 = findViewById<Button>(R.id.answerButton4)
        val addButton = findViewById<ImageButton>(R.id.addButton)
        val numberedInput = findViewById<EditText>(R.id.numberedInput)

        // Top bar actions
        closeIcon.setOnClickListener { finish() }
        listIcon.setOnClickListener { Toast.makeText(this, "Options menu", Toast.LENGTH_SHORT).show() }

        // Spinner
        val quizTypes = arrayOf("Multiple Choice", "True/False", "Short Answer")
        quizTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quizTypes)

        // For each answer button, open edit dialog
        val editAnswer = { btn: Button, label: String ->
            val editText = EditText(this)
            editText.setText(btn.text.toString())
            editText.setSelection(editText.text.length)
            AlertDialog.Builder(this)
                .setTitle(label)
                .setView(editText)
                .setPositiveButton("OK") { dialog, _ -> btn.text = editText.text.toString() }
                .setNegativeButton("Cancel", null)
                .show()
        }

        answerButton1.setOnClickListener { editAnswer(answerButton1, "Edit Answer 1") }
        answerButton2.setOnClickListener { editAnswer(answerButton2, "Edit Answer 2") }
        answerButton3.setOnClickListener { editAnswer(answerButton3, "Edit Answer 3") }
        answerButton4.setOnClickListener { editAnswer(answerButton4, "Edit Answer 4") }

        addButton.setOnClickListener {
            val question = questionInput.text.toString()
            val answers = listOf(
                answerButton1.text.toString(),
                answerButton2.text.toString(),
                answerButton3.text.toString(),
                answerButton4.text.toString()
            )
            val number = numberedInput.text.toString()
            Toast.makeText(this, "Question added!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // --- KEY PART: open edit_point and time_limit forms ---

        pointsButton.setOnClickListener {
            val intent = Intent(this, edit_point::class.java)
            startActivityForResult(intent, REQ_CODE_POINTS)
        }

        timeButton.setOnClickListener {
            val intent = Intent(this, time_limit::class.java)
            startActivityForResult(intent, REQ_CODE_TIME)
        }
    }

    // Handle the result from edit_point and time_limit
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                REQ_CODE_POINTS -> {
                    val selectedPoints = data.getStringExtra("SELECTED_POINTS")
                    if (!selectedPoints.isNullOrEmpty()) pointsButton.text = selectedPoints
                }
                REQ_CODE_TIME -> {
                    val selectedTime = data.getStringExtra("SELECTED_TIME")
                    if (!selectedTime.isNullOrEmpty()) timeButton.text = selectedTime
                }
            }
        }
    }

    companion object {
        private const val REQ_CODE_POINTS = 101
        private const val REQ_CODE_TIME = 102
    }
}
