package com.example.projekt_bam

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import android.util.Log
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class KeystoreWrapper(private val context: Context) {

    private val KEY_ALIAS = "your_key_alias"

    init {
        Log.d("123", "create key")
        createKey()
    }

    companion object {
        @Volatile
        private var instance: KeystoreWrapper? = null

        fun getInstance(context: Context): KeystoreWrapper {
            return instance ?: synchronized(this) {
                instance ?: KeystoreWrapper(context).also { instance = it }
            }
        }
    }

    private fun createKey() {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        // Sprawdź, czy klucz już istnieje
        if (!keyStore.containsAlias(KEY_ALIAS)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .build()
            keyGenerator.init(keyGenParameterSpec)
            keyGenerator.generateKey()
        }
    }

    fun encryptData(data: String): EncryptedData {
        val cipher = Cipher.getInstance("${KeyProperties.KEY_ALGORITHM_AES}/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}")

        cipher.init(Cipher.ENCRYPT_MODE, getKey())

        val encryptedBytes = cipher.doFinal(data.toByteArray())

        val iv = cipher.iv

        return EncryptedData(Base64.encodeToString(encryptedBytes, Base64.DEFAULT), iv)
    }

    fun decryptData(encryptedData: EncryptedData): String {
        val cipher = Cipher.getInstance("${KeyProperties.KEY_ALGORITHM_AES}/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}")

        // Initialize the cipher with the IV
        cipher.init(Cipher.DECRYPT_MODE, getKey(), IvParameterSpec(encryptedData.iv))

        val encryptedBytes = Base64.decode(encryptedData.data, Base64.DEFAULT)
        val decryptedBytes = cipher.doFinal(encryptedBytes)
        return String(decryptedBytes)
    }

    private fun getKey(): SecretKey {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)
        return keyStore.getKey(KEY_ALIAS, null) as SecretKey
    }

    data class EncryptedData(val data: String, val iv: ByteArray)
}
