package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class library_form : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_library_form)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.library_form)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            // Replace `CreateQuizActivity::class.java` with your target activity class!
            val intent = Intent(this, start_quiz::class.java)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_library

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, home_page::class.java))
                    finish()
                    true
                }
                R.id.nav_library -> {
                    // Already here
                    true
                }
                // Uncomment and implement these if you want to navigate to other pages:

                R.id.nav_create -> {
                    val intent = Intent(this, create_quiz::class.java)
                    startActivity(intent)
                    true
                }/*
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileForm::class.java)
                    startActivity(intent)
                    true
                }
                */
                else -> false
            }
        }
    }
}
