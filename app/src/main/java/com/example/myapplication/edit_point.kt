package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class edit_point : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_point)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edit_point)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val group1 = findViewById<MaterialButtonToggleGroup>(R.id.pointsToggleGroup)
        val group2 = findViewById<MaterialButtonToggleGroup>(R.id.pointsToggleGroup2)
        val group3 = findViewById<MaterialButtonToggleGroup>(R.id.pointsToggleGroup3)
        val okButton = findViewById<Button>(R.id.okButton)
        val groups = listOf(group1, group2, group3)

        // Only allow one group to have a selection
        for (i in groups.indices) {
            groups[i].addOnButtonCheckedListener { _, checkedId, isChecked ->
                if (isChecked && checkedId != View.NO_ID) {
                    for (j in groups.indices) {
                        if (i != j) groups[j].clearChecked()
                    }
                }
            }
        }

        okButton.setOnClickListener {
            val checkedBtn1 = group1.checkedButtonId
            val checkedBtn2 = group2.checkedButtonId
            val checkedBtn3 = group3.checkedButtonId

            val selectedPoints: String? = when {
                checkedBtn1 != View.NO_ID -> findViewById<MaterialButton>(checkedBtn1).text.toString()
                checkedBtn2 != View.NO_ID -> findViewById<MaterialButton>(checkedBtn2).text.toString()
                checkedBtn3 != View.NO_ID -> findViewById<MaterialButton>(checkedBtn3).text.toString()
                else -> null
            }

            if (selectedPoints == null) {
                Toast.makeText(this, "Please select a points value.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Return the result to calling activity
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_POINTS", selectedPoints)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
