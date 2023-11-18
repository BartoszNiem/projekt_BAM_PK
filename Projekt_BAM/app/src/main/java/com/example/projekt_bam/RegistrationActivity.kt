package com.example.projekt_bam

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var peselEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var idNumberEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Inicjalizacja elementów interfejsu użytkownika
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword)
        firstNameEditText = findViewById(R.id.editTextFirstName)
        lastNameEditText = findViewById(R.id.editTextLastName)
        peselEditText = findViewById(R.id.editTextPesel)
        addressEditText = findViewById(R.id.editTextAddress)
        idNumberEditText = findViewById(R.id.editTextIdNumber)
        phoneNumberEditText = findViewById(R.id.editTextPhoneNumber)
        registerButton = findViewById(R.id.buttonRegister)

        // Obsługa kliknięcia przycisku rejestracji
        registerButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val pesel = peselEditText.text.toString()
        val address = addressEditText.text.toString()
        val idNumber = idNumberEditText.text.toString()
        val phoneNumber = phoneNumberEditText.text.toString()

        // Sprawdzenie warunków rejestracji
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
            firstName.isEmpty() || lastName.isEmpty() || pesel.isEmpty() || address.isEmpty() ||
            idNumber.isEmpty() || phoneNumber.isEmpty()) {
            showToast("Wypełnij wszystkie pola")
            return
        }

        if (password != confirmPassword) {
            showToast("Hasła nie pasują do siebie")
            return
        }

        // Tutaj dodaj logikę zapisu użytkownika do bazy danych lub serwera

        showToast("Rejestracja udana")
        finish() // Zakończ aktywność rejestracji
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
