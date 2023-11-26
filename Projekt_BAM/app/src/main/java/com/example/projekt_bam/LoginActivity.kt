package com.example.projekt_bam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    private lateinit var database: AppDatabase
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val keystoreInstance = KeystoreWrapper.getInstance(applicationContext)

        // Inicjalizacja elementów interfejsu użytkownika
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)

        // Inicjalizacja obiektu UserDao (dostosuj do swojej implementacji)
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()

        // Inicjalizacja SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Obsługa kliknięcia przycisku logowania
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Wprowadź adres e-mail i hasło", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(keystoreInstance, email, password)
            }
        }
    }

    private fun loginUser(keystoreInstance: KeystoreWrapper, email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val user = database.userDao().getUserByEmail(email)

            if (user != null) {

                // Zapisz informacje o zalogowanym użytkowniku w SharedPreferences
                sharedPreferences.edit().putBoolean("is_logged_in", true).apply()
                sharedPreferences.edit().putString("logged_in_email", user.email).apply()

                // Logowanie udane, otwórz nową aktywność lub wykonaj inne operacje
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Logowanie udane", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                // Logowanie nieudane, wyświetl komunikat błędu
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Logowanie nieudane", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
