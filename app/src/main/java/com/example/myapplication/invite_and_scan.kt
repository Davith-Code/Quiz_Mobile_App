package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class invite_and_scan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_and_scan)

        val backArrow: ImageView = findViewById(R.id.backArrow)
        val btnInvitePlayNow: Button = findViewById(R.id.btnInvitePlayNow)
        val btnQRCode: Button = findViewById(R.id.btnQRCode)

        backArrow.setOnClickListener {
            finish()
        }

        btnInvitePlayNow.setOnClickListener {
            val intent = Intent(this, quiz1::class.java)
            startActivity(intent)
        }

        btnQRCode.setOnClickListener {
            val intent = Intent(this, qr_code::class.java)
            startActivity(intent)
        }
    }
}
