package com.example.projekt_bam

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditProfileActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    private lateinit var emailEditText: EditText
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var peselEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var idNumberEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var saveChangesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()

        emailEditText = findViewById(R.id.editTextEmail)
        firstNameEditText = findViewById(R.id.editTextFirstName)
        lastNameEditText = findViewById(R.id.editTextLastName)
        peselEditText = findViewById(R.id.editTextPesel)
        addressEditText = findViewById(R.id.editTextAddress)
        idNumberEditText = findViewById(R.id.editTextIdNumber)
        phoneNumberEditText = findViewById(R.id.editTextPhoneNumber)
        saveChangesButton = findViewById(R.id.buttonSaveChanges)

        GlobalScope.launch(Dispatchers.Main) {
            val loggedInUser = getLoggedInUser()
            loggedInUser?.let {
                emailEditText.setText(it.email)
                firstNameEditText.setText(it.firstName)
                lastNameEditText.setText(it.lastName)
                peselEditText.setText(it.pesel)
                addressEditText.setText(it.address)
                idNumberEditText.setText(it.idNumber)
                phoneNumberEditText.setText(it.phoneNumber)
            }
            saveChangesButton.setOnClickListener {
                saveChanges(loggedInUser)
            }
        }
    }

    suspend fun getLoggedInUser(): UserEntity? {
        return withContext(Dispatchers.IO) {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val email = sharedPreferences.getString("logged_in_email", "")

            return@withContext if (email != "") {
                val userDao = database.userDao()
                userDao.getUserByEmail(email.toString())
            } else {
                null
            }
        }
    }

    private fun saveChanges(user: UserEntity?) {
        user?.let {
            it.firstName = firstNameEditText.text.toString().trim()
            it.lastName = lastNameEditText.text.toString().trim()
            it.pesel = peselEditText.text.toString().trim()
            it.address = addressEditText.text.toString().trim()
            it.idNumber = idNumberEditText.text.toString().trim()
            it.phoneNumber = phoneNumberEditText.text.toString().trim()

            GlobalScope.launch(Dispatchers.IO) {
                database.userDao().updateUser(it)
            }

            // Dodaj kod obsługujący zapisanie zmian i powrót do HomeActivity
            finish()
        }
    }
}
