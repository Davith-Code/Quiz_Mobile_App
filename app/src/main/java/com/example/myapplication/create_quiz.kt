package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class create_quiz : AppCompatActivity() {

    private lateinit var imageCover: ImageView
    private lateinit var placeholderAddImage: LinearLayout
    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText
    private lateinit var spinnerCollection: Spinner
    private lateinit var spinnerTheme: Spinner
    private lateinit var spinnerVisibility: Spinner
    private lateinit var spinnerQuestionVisibility: Spinner
    private lateinit var editKeyword: EditText
    private lateinit var chipGroupKeywords: ChipGroup
    private lateinit var btnSave: Button
    private lateinit var btnAddQuestion: Button

    private val PICK_ADD_IMAGE = 200
    private val keywordList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quiz)

        // Bind views
        imageCover = findViewById(R.id.image_view_cover)
        placeholderAddImage = findViewById(R.id.placeholder_add_image)
        editTitle = findViewById(R.id.edit_text_title)
        editDescription = findViewById(R.id.edit_text_description)
        spinnerCollection = findViewById(R.id.spinner_collection)
        spinnerTheme = findViewById(R.id.spinner_theme)
        spinnerVisibility = findViewById(R.id.spinner_visibility)
        spinnerQuestionVisibility = findViewById(R.id.spinner_question_visibility)
        editKeyword = findViewById(R.id.edit_text_keyword)
        chipGroupKeywords = findViewById(R.id.chip_group_keywords)
        btnSave = findViewById(R.id.btnSave)
        btnAddQuestion = findViewById(R.id.btnAddQuestion)
        val btnClose = findViewById<ImageView>(R.id.button_close)

        // Spinners (sample data, replace with your real data if needed)
        val collections = listOf("General", "Math", "Science", "History")
        spinnerCollection.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, collections)
        val themes = listOf("Classic", "Purple", "Neon")
        spinnerTheme.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, themes)
        val visibilities = listOf("Everyone", "Only Me", "Private")
        spinnerVisibility.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, visibilities)
        val questionVisibilities = listOf("Visible", "Hidden")
        spinnerQuestionVisibility.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, questionVisibilities)

        // Cover image: open custom picker
        val openPicker = {
            val intent = Intent(this, add_image::class.java)
            startActivityForResult(intent, PICK_ADD_IMAGE)
        }
        placeholderAddImage.setOnClickListener { openPicker() }
        imageCover.setOnClickListener { openPicker() }

        // Keyword input, add chip on enter/IME done
        editKeyword.inputType = InputType.TYPE_CLASS_TEXT
        editKeyword.setOnEditorActionListener { _, _, _ ->
            val text = editKeyword.text.toString().trim()
            if (text.isNotEmpty() && !keywordList.contains(text)) {
                addKeywordChip(text)
                editKeyword.setText("")
            }
            true
        }

        // Save Button (replace with your own logic)
        btnSave.setOnClickListener {
            Toast.makeText(this, "Quiz saved (not really, just a demo)", Toast.LENGTH_SHORT).show()
        }
        // Add Question Button (replace with your own logic)
        btnAddQuestion.setOnClickListener {
            Toast.makeText(this, "Add Question tapped!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, add_question::class.java)
             startActivity(intent)
        }

        btnClose.setOnClickListener {
            // Example: Close and return to home
            val intent = Intent(this, home_page::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

    // Add a chip for each keyword, remove on close icon click
    private fun addKeywordChip(keyword: String) {
        val chip = Chip(this)
        chip.text = keyword
        chip.isCloseIconVisible = true
        chip.setOnCloseIconClickListener {
            chipGroupKeywords.removeView(chip)
            keywordList.remove(keyword)
        }
        chipGroupKeywords.addView(chip)
        keywordList.add(keyword)
    }

    // Handle result from custom image picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_ADD_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            val drawableRes = data.getIntExtra("SELECTED_IMAGE_RES", -1)
            if (drawableRes != -1) {
                imageCover.setImageResource(drawableRes)
                imageCover.visibility = View.VISIBLE
                placeholderAddImage.visibility = View.GONE
            }
        }
    }
}
