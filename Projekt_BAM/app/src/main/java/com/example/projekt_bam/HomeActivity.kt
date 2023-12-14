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
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()
        val keystoreInstance = KeystoreWrapper.getInstance(applicationContext)

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

        val buttonLogOut: Button = findViewById(R.id.buttonLogout)
        buttonLogOut.setOnClickListener {
            logoutUser()
        }

        val buttonShowDecrypted: Button = findViewById(R.id.buttonShowDecryptedData)
        buttonShowDecrypted.setOnClickListener {
            if (buttonShowDecrypted.text != "Pokaż odszyfrowane dane") {
                this.showEncryptedData()
                buttonShowDecrypted.text = "Pokaż odszyfrowane dane"
            } else {
                this.showDecryptedData(keystoreInstance)
                buttonShowDecrypted.text = "Pokaż zaszyfrowane dane"
            }
        }

        this.showEncryptedData()
    }

    private fun showEncryptedData() {
        val textViewFirstName: TextView = findViewById(R.id.textViewFirstName)
        val textViewLastName: TextView = findViewById(R.id.textViewLastName)
        val textViewPesel: TextView = findViewById(R.id.textViewPesel)
        val textViewIdNumber: TextView = findViewById(R.id.textViewIdNumber)
        val textViewPhoneNumber: TextView = findViewById(R.id.textViewPhoneNumber)
        val textViewAddress: TextView = findViewById(R.id.textViewAddress)

        GlobalScope.launch(Dispatchers.Main) {
            val user = getLoggedInUser()

            if (user != null) {
                textViewFirstName.text = user.firstName
                textViewLastName.text = user.lastName
                textViewIdNumber.text = user.idNumber
                textViewPesel.text = user.pesel
                textViewPhoneNumber.text = user.phoneNumber
                textViewAddress.text = user.address
            }
        }
    }

    private fun showDecryptedData(keystoreInstance: KeystoreWrapper) {
        val textViewFirstName: TextView = findViewById(R.id.textViewFirstName)
        val textViewLastName: TextView = findViewById(R.id.textViewLastName)
        val textViewPesel: TextView = findViewById(R.id.textViewPesel)
        val textViewIdNumber: TextView = findViewById(R.id.textViewIdNumber)
        val textViewPhoneNumber: TextView = findViewById(R.id.textViewPhoneNumber)
        val textViewAddress: TextView = findViewById(R.id.textViewAddress)

        GlobalScope.launch(Dispatchers.Main) {
            val decryptedUser = decryptUser(keystoreInstance, getLoggedInUser())

            decryptedUser?.let {
                textViewFirstName.setText(it.firstName)
                textViewLastName.setText(it.lastName)
                textViewPesel.setText(it.pesel)
                textViewAddress.setText(it.address)
                textViewIdNumber.setText(it.idNumber)
                textViewPhoneNumber.setText(it.phoneNumber)
            }
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

    private fun logoutUser() {
        // Wyczyść informacje o zalogowanym użytkowniku w SharedPreferences
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("is_logged_in", false).apply()
        sharedPreferences.edit().remove("logged_in_email").apply()

        // Przenieś użytkownika do LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
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

}
