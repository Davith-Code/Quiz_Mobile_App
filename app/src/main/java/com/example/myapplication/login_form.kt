package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class login_form : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        val backButton: ImageView = findViewById(R.id.backButton)
        val forgotPasswordText: TextView = findViewById(R.id.forgotPasswordText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val eyeIcon: ImageView = findViewById(R.id.eyeIcon)

        // 🔙 Back to Welcome page
        backButton.setOnClickListener {
            val intent = Intent(this, welcome_page_1::class.java)
            startActivity(intent)
            finish()
        }

        // 🔐 Navigate to forgot password page
        forgotPasswordText.setOnClickListener {
            val intent = Intent(this, forget_password_form::class.java)
            startActivity(intent)
        }

        // 👁 Toggle password visibility
        eyeIcon.setOnClickListener {
            isPasswordVisible = !isPasswordVisible

            if (isPasswordVisible) {
                passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                eyeIcon.setImageResource(R.drawable.eyeon) // Make sure you have this icon
            } else {
                passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                eyeIcon.setImageResource(R.drawable.eyeoff)
            }

            // Keep cursor at the end
            passwordEditText.setSelection(passwordEditText.text.length)
        }
    }
}
