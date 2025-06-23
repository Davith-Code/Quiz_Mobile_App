package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class time_limit : AppCompatActivity() {

    private var selectedButton: Button? = null
    private var selectedTimeText: String = "20 sec" // default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_time_limit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.time_limit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttons = listOf(
            findViewById<Button>(R.id.btn_5_sec),
            findViewById<Button>(R.id.btn_10_sec),
            findViewById<Button>(R.id.btn_20_sec_popup),
            findViewById<Button>(R.id.btn_30_sec),
            findViewById<Button>(R.id.btn_45_sec),
            findViewById<Button>(R.id.btn_60_sec),
            findViewById<Button>(R.id.btn_90_sec),
            findViewById<Button>(R.id.btn_120_sec)
        )
        val btn_ok = findViewById<Button>(R.id.btn_ok)

        // Set initial selection
        selectedButton = findViewById(R.id.btn_20_sec_popup)
        highlightButton(selectedButton)

        for (button in buttons) {
            button.setOnClickListener {
                highlightButton(button)
                selectedTimeText = button.text.toString()
            }
        }

        btn_ok.setOnClickListener {
            // Pass the selected value back to the calling activity
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_TIME", selectedTimeText)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun highlightButton(selected: Button?) {
        // Reset all buttons to default
        val buttons = listOf(
            findViewById<Button>(R.id.btn_5_sec),
            findViewById<Button>(R.id.btn_10_sec),
            findViewById<Button>(R.id.btn_20_sec_popup),
            findViewById<Button>(R.id.btn_30_sec),
            findViewById<Button>(R.id.btn_45_sec),
            findViewById<Button>(R.id.btn_60_sec),
            findViewById<Button>(R.id.btn_90_sec),
            findViewById<Button>(R.id.btn_120_sec)
        )
        for (btn in buttons) {
            btn.setBackgroundTintList(getColorStateList(android.R.color.darker_gray))
            btn.setTextColor(getColor(android.R.color.black))
        }
        // Highlight selected
        selected?.setBackgroundTintList(getColorStateList(R.color.purple_700))
        selected?.setTextColor(getColor(android.R.color.white))
        selectedButton = selected
    }
}
