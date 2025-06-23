package com.example.myapplication

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class create_new_password : AppCompatActivity() {

    private lateinit var newPassword: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var toggleNewPassword: ImageView
    private lateinit var toggleConfirmPassword: ImageView
    private lateinit var continueButton: Button
    private lateinit var backButton: ImageView
    private lateinit var rememberMeCheckbox: CheckBox

    private var isNewPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_new_password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_new_password)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        newPassword = findViewById(R.id.newPassword)
        confirmPassword = findViewById(R.id.confirmPassword)
        toggleNewPassword = findViewById(R.id.toggleNewPassword)
        toggleConfirmPassword = findViewById(R.id.toggleConfirmPassword)
        continueButton = findViewById(R.id.continueButton)
        backButton = findViewById(R.id.backButton)
        rememberMeCheckbox = findViewById(R.id.rememberMeCheckbox)

        // Toggle New Password visibility
        toggleNewPassword.setOnClickListener {
            isNewPasswordVisible = !isNewPasswordVisible
            if (isNewPasswordVisible) {
                newPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                toggleNewPassword.setImageResource(R.drawable.eyeon) // change icon if available
            } else {
                newPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                toggleNewPassword.setImageResource(R.drawable.eyeoff)
            }
            newPassword.setSelection(newPassword.text.length)
        }

        // Toggle Confirm Password visibility
        toggleConfirmPassword.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            if (isConfirmPasswordVisible) {
                confirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                toggleConfirmPassword.setImageResource(R.drawable.eyeon)
            } else {
                confirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                toggleConfirmPassword.setImageResource(R.drawable.eyeoff)
            }
            confirmPassword.setSelection(confirmPassword.text.length)
        }

        // Back button
        backButton.setOnClickListener {
            finish()
        }

        // Continue button
        continueButton.setOnClickListener {
            val newPass = newPassword.text.toString()
            val confirmPass = confirmPassword.text.toString()

            if (newPass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "Please fill in both password fields", Toast.LENGTH_SHORT).show()
            } else if (newPass != confirmPass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // ✅ Passwords match — continue to next step or save
                Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, change_password_successful::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
