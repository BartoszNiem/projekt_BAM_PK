package com.example.projekt_bam

import androidx.room.TypeConverter
import android.util.Base64

class Converters {

    @TypeConverter
    fun fromEncryptedData(value: KeystoreWrapper.EncryptedData?): String? {
        return value?.let {
            val ivString = String(Base64.encode(it.iv, Base64.DEFAULT), Charsets.UTF_8)
            val dataString = Base64.encodeToString(it.data.toByteArray(), Base64.DEFAULT)
            "${ivString}|${dataString}"
        }
    }


    @TypeConverter
    fun toEncryptedData(value: String?): KeystoreWrapper.EncryptedData? {
        return value?.let {
            val parts = it.split("|")
            KeystoreWrapper.EncryptedData(parts[1], Base64.decode(parts[0], Base64.DEFAULT))
        }
    }

}

