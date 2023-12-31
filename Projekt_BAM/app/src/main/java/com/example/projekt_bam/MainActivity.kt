package com.example.projekt_bam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToLogin: Button = findViewById(R.id.buttonGoToLogin)

        // Obsługa kliknięcia przycisku, aby przejść do RegistrationActivity
        buttonGoToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val buttonGoToRegistration: Button = findViewById(R.id.buttonGoToRegistration)

        // Obsługa kliknięcia przycisku, aby przejść do RegistrationActivity
        buttonGoToRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
