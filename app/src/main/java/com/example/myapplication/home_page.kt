package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class home_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Set the layout for the activity
        setContentView(R.layout.activity_home_page)

        // Apply system insets (status bar, navigation bar) to the root view for proper padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_page)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            // Replace `CreateQuizActivity::class.java` with your target activity class!
            val intent = Intent(this, start_quiz::class.java)
            startActivity(intent)
        }


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle "Home" navigation (you could stay in the current activity)
                    true
                }
                R.id.nav_library -> {
                    // When the "Library" item is clicked, start the LibraryForm activity
                    val intent = Intent(this, library_form::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_create -> {
                    // When the "Create" item is clicked, start the CreateForm activity
                    val intent = Intent(this, create_quiz::class.java)
                    startActivity(intent)
                    true
                }
                /*
                R.id.nav_profile -> {
                    // When the "Profile" item is clicked, start the ProfileForm activity
                    val intent = Intent(this, ProfileForm::class.java)
                    startActivity(intent)
                    true
                }*/
                else -> false
            }
        }
    }
}
