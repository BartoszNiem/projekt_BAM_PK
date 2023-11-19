package com.example.projekt_bam

import android.content.Context
import com.example.projekt_bam.LoginActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val welcomeMessageTextView: TextView = findViewById(R.id.textViewWelcomeMessage)

        val loggedInUser = getLoggedInUser()

        welcomeMessageTextView.text = "Witaj, ${loggedInUser?.email}!"
    }

    fun getLoggedInUser(): UserEntity? {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getLong("user_id", -1)

        return if (userId.toInt() != -1) {
            val userDao = database.userDao()
            userDao.getUserById(userId)
        } else {
            null
        }
    }
}
