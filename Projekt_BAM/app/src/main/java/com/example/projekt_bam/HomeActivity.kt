package com.example.projekt_bam

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()

        val welcomeMessageTextView: TextView = findViewById(R.id.textViewWelcomeMessage)

        GlobalScope.launch(Dispatchers.Main) {
            val loggedInUser = getLoggedInUser()
            welcomeMessageTextView.text = "Witaj, ${loggedInUser?.email}!"
        }

        val buttonEditProfile: Button = findViewById(R.id.buttonEditProfile)

        buttonEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

    suspend fun getLoggedInUser(): UserEntity? {
        return withContext(Dispatchers.IO) {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val email = sharedPreferences.getString("logged_in_email", "")

            return@withContext if (email != "") {
                val userDao = database.userDao()
                userDao.getUserByEmail(email.toString())
            } else {
                null
            }
        }
    }

}
