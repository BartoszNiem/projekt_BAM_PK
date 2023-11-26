package com.example.projekt_bam

import android.os.Bundle
import android.util.Log
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

        val keystoreInstance = KeystoreWrapper.getInstance(applicationContext)

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
            val decryptedUser = decryptUser(keystoreInstance, loggedInUser)

            decryptedUser?.let {
                emailEditText.setText(it.email)
                firstNameEditText.setText(it.firstName)
                lastNameEditText.setText(it.lastName)
                peselEditText.setText(it.pesel)
                addressEditText.setText(it.address)
                idNumberEditText.setText(it.idNumber)
                phoneNumberEditText.setText(it.phoneNumber)
            }
            saveChangesButton.setOnClickListener {
                saveChanges(keystoreInstance, decryptedUser)
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

    private fun saveChanges(keystoreInstance: KeystoreWrapper, user: UserEntity?) {
        user?.let {
            it.firstName = firstNameEditText.text.toString().trim()
            it.lastName = lastNameEditText.text.toString().trim()
            it.pesel = peselEditText.text.toString().trim()
            it.address = addressEditText.text.toString().trim()
            it.idNumber = idNumberEditText.text.toString().trim()
            it.phoneNumber = phoneNumberEditText.text.toString().trim()

            val encryptedUser = encryptUser(keystoreInstance, it)

            GlobalScope.launch(Dispatchers.IO) {
                database.userDao().updateUser(encryptedUser)
            }

            // Dodaj kod obsługujący zapisanie zmian i powrót do HomeActivity
            finish()
        }
    }

    private fun decryptUser(keystoreInstance: KeystoreWrapper, user: UserEntity?): UserEntity? {
        if (user != null) {

            if (user.pesel != "") {
                user.pesel = keystoreInstance.decryptData(
                    KeystoreWrapper.EncryptedData(
                        user.pesel,
                        user.peselIV
                    )
                )
            }

            if (user.address != "") {
                user.address = keystoreInstance.decryptData(
                    KeystoreWrapper.EncryptedData(
                        user.address,
                        user.addressIV
                    )
                )
            }

            if (user.idNumber != "") {
                user.idNumber = keystoreInstance.decryptData(
                    KeystoreWrapper.EncryptedData(
                        user.idNumber,
                        user.idNumberIV
                    )
                )
            }

            if (user.phoneNumber != "") {
                user.phoneNumber = keystoreInstance.decryptData(
                    KeystoreWrapper.EncryptedData(
                        user.phoneNumber,
                        user.phoneNumberIV
                    )
                )
            }

            return UserEntity(
                id = user.id,
                email = user.email,
                password = user.password,
                passwordIV = user.passwordIV,
                firstName = user.firstName,
                lastName = user.lastName,
                pesel = user.pesel,
                peselIV = user.peselIV,
                address = user.address,
                addressIV = user.addressIV,
                idNumber = user.idNumber,
                idNumberIV = user.idNumberIV,
                phoneNumber = user.phoneNumber,
                phoneNumberIV = user.phoneNumberIV
            )
        }
        return null
    }

    private fun encryptUser(keystoreInstance: KeystoreWrapper, user: UserEntity): UserEntity {
        val pesel = keystoreInstance.encryptData(user.pesel)
        val address = keystoreInstance.encryptData(user.address)
        val idNumber = keystoreInstance.encryptData(user.idNumber)
        val phoneNumber = keystoreInstance.encryptData(user.phoneNumber)
        return UserEntity(
            id = user.id,
            email = user.email,
            password = user.password,
            passwordIV = user.passwordIV,
            firstName = user.firstName,
            lastName = user.lastName,
            pesel = pesel.data,
            peselIV = pesel.iv,
            address = address.data,
            addressIV = address.iv,
            idNumber = idNumber.data,
            idNumberIV = idNumber.iv,
            phoneNumber = phoneNumber.data,
            phoneNumberIV = phoneNumber.iv
        )
    }
}
