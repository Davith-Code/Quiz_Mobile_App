package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class add_image : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)

        // Top bar close button
        val btnClose = findViewById<ImageView>(R.id.btnClose)
        btnClose.setOnClickListener { finish() }

        // Image click listeners for each image
        findViewById<ImageView>(R.id.image1).setOnClickListener {
            returnResultWithImage(R.drawable.image_banana)
        }
        findViewById<ImageView>(R.id.image2).setOnClickListener {
            returnResultWithImage(R.drawable.image_chair)
        }
        findViewById<ImageView>(R.id.image3).setOnClickListener {
            returnResultWithImage(R.drawable.image_chair)
        }
        findViewById<ImageView>(R.id.image4).setOnClickListener {
            returnResultWithImage(R.drawable.image_banana)
        }
        // Add more as needed, both in XML and here
    }

    private fun returnResultWithImage(drawableRes: Int) {
        val intent = Intent()
        intent.putExtra("SELECTED_IMAGE_RES", drawableRes)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
