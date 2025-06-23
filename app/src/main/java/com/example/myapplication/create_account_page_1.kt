package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.*

class create_account_page_1 : AppCompatActivity() {

    private lateinit var fullNameInput: EditText
    private lateinit var dobInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var countrySpinner: Spinner
    private lateinit var ageSpinner: Spinner
    private lateinit var continueButton: Button
    private lateinit var calendarIcon: ImageView

    private val calendar: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account_page1)

        // Handle system-bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_account_page1)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // -------- view bindings ----------
        fullNameInput   = findViewById(R.id.fullNameInput)
        dobInput        = findViewById(R.id.dobInput)
        phoneInput      = findViewById(R.id.phoneInput)
        countrySpinner  = findViewById(R.id.countrySpinner)
        ageSpinner      = findViewById(R.id.ageSpinner)
        continueButton  = findViewById(R.id.continueButton)
        calendarIcon    = findViewById(R.id.calendarIcon)
        val backButton: ImageView = findViewById(R.id.backButton)
        // ---------------------------------

        /* ───────────────  Date picker ─────────────── */
        val dateSet = DatePickerDialog.OnDateSetListener { _, y, m, d ->
            calendar.set(y, m, d)
            dobInput.setText(dateFormat.format(calendar.time))
        }
        val showDatePicker = View.OnClickListener {
            DatePickerDialog(
                this,
                dateSet,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        dobInput.setOnClickListener(showDatePicker)
        calendarIcon.setOnClickListener(showDatePicker)

        /* ───────────────  Country spinner ─────────────── */
        ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            countrySpinner.adapter = adapter
        }

        /* ───────────────  Age spinner (18-100) ─────────────── */
        val ages = (12..100).map { it.toString() }
        val ageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ages).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        ageSpinner.adapter = ageAdapter

        /* ───────────────  Phone formatter: on focus lost ─────────────── */
        phoneInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val phone = phoneInput.text.toString()
                val formatted = PhoneNumberUtils.formatNumber(phone, "KH")
                if (formatted != null) {
                    phoneInput.setText(formatted)
                }
            }
        }

        /* ───────────────  Navigation buttons ─────────────── */
        backButton.setOnClickListener {
            startActivity(Intent(this, create_form::class.java))
            finish()
        }

        continueButton.setOnClickListener {
            if (validateFields()) {
                startActivity(Intent(this, create_account_page_2::class.java))
                finish()
            }
        }
    }

    /* ───────────────  Simple validation ─────────────── */
    private fun validateFields(): Boolean {
        return when {
            fullNameInput.text.isNullOrBlank() -> {
                fullNameInput.error = "Required"
                false
            }
            dobInput.text.isNullOrBlank() -> {
                dobInput.error = "Select your date of birth"
                false
            }
            phoneInput.text.isNullOrBlank() || phoneInput.text.length < 8 -> {
                phoneInput.error = "Invalid number"
                false
            }
            else -> true
        }
    }
}
