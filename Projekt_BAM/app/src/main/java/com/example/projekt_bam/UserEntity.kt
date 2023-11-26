package com.example.projekt_bam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "password_IV")
    val passwordIV: ByteArray,
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @ColumnInfo(name = "last_name")
    var lastName: String,
    @ColumnInfo(name = "pesel")
    var pesel: String = "",
    @ColumnInfo(name = "pesel_IV")
    val peselIV: ByteArray = byteArrayOf(),
    @ColumnInfo(name = "address")
    var address: String = "",
    @ColumnInfo(name = "address_IV")
    val addressIV: ByteArray = byteArrayOf(),
    @ColumnInfo(name = "id_number")
    var idNumber: String = "",
    @ColumnInfo(name = "id_nubmer_IV")
    val idNumberIV: ByteArray = byteArrayOf(),
    @ColumnInfo(name = "phone_number")
    var phoneNumber: String = "",
    @ColumnInfo(name = "phone_number_IV")
    val phoneNumberIV: ByteArray = byteArrayOf(),
)
