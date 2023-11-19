package com.example.projekt_bam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicjalizacja elementów interfejsu użytkownika
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)

        // Inicjalizacja obiektu UserDao (dostosuj do swojej implementacji)
         database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()

        // Obsługa kliknięcia przycisku logowania
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Wprowadź adres e-mail i hasło", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val user = database.userDao().getUserByEmailAndPassword(email, password)

            if (user != null) {
                // Logowanie udane, zapisz zalogowanego użytkownika i otwórz nową aktywność HomeActivity
                saveLoggedInUser(user)
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

    private fun saveLoggedInUser(user: UserEntity) {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("user_id", user.id)
        editor.putString("email", user.email)
        editor.apply()
    }
}
