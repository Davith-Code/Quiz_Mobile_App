package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class forget_password_form2 : AppCompatActivity() {

    private lateinit var resendTimerText: TextView
    private lateinit var backButton: ImageView
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password_form2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.forget_password_form2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        continueButton = findViewById(R.id.continueOtpButton)
        resendTimerText = findViewById(R.id.resendTimerText)
        backButton = findViewById(R.id.backButton)

        // 🔙 Go back
        backButton.setOnClickListener {
            val intent = Intent(this, forget_password_form::class.java)
            startActivity(intent)
            finish()
        }

        // ▶️ Continue button to next step
        continueButton.setOnClickListener {
            val intent = Intent(this, create_new_password::class.java) // or wherever you want
            startActivity(intent)
            finish()
        }

        // ⏱ Start countdown
        startResendCountdown()
    }

    private fun startResendCountdown() {
        val totalTime = 55 * 1000L // 55 seconds
        val timer = object : CountDownTimer(totalTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                resendTimerText.text = "You can resend code in $seconds s"
            }

            override fun onFinish() {
                resendTimerText.text = "Resend code now"
                // You can set clickable=true here if needed
            }
        }
        timer.start()
    }
}
