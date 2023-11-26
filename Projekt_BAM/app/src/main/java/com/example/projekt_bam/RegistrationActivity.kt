package com.example.projekt_bam

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase


    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val keystoreInstance = KeystoreWrapper.getInstance(applicationContext)

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()

        // Inicjalizacja elementów interfejsu użytkownika
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword)
        firstNameEditText = findViewById(R.id.editTextFirstName)
        lastNameEditText = findViewById(R.id.editTextLastName)
        registerButton = findViewById(R.id.buttonRegister)

        // Obsługa kliknięcia przycisku rejestracji
        registerButton.setOnClickListener {
            registerUser(keystoreInstance)
            showAllUsers()
        }
    }

    private fun registerUser(keystoreInstance: KeystoreWrapper) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()

        // Sprawdzenie warunków rejestracji
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
            firstName.isEmpty() || lastName.isEmpty()) {
            showToast("Wypełnij wszystkie pola")
            return
        }

        if (password != confirmPassword) {
            showToast("Hasła nie pasują do siebie")
            return
        }

        val encryptedPassword = keystoreInstance.encryptData(password)

        // Tutaj dodaj logikę zapisu użytkownika do bazy danych lub serwera

        // Save the IVs as Base64-encoded strings
        val user = UserEntity(
            email = email,
            password = encryptedPassword.data,
            passwordIV = encryptedPassword.iv,
            firstName = firstName,
            lastName = lastName,
        )

        GlobalScope.launch(Dispatchers.IO) {
            database.userDao().insertUser(user)
            val user = database.userDao().getUserByEmail(email)
            Log.d("Users", "User: $user")
        }



        showToast("Rejestracja udana")
        finish() // Zakończ aktywność rejestracji
    }

    private fun showAllUsers() {
        GlobalScope.launch(Dispatchers.IO) {
            val allUsers = database.userDao().getAllUsers()
            withContext(Dispatchers.Main) {
                Log.d("Users", "All users in the database:")
                for (user in allUsers) {
                    Log.d("Users", "User: $user")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
