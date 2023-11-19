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
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "pesel")
    val pesel: String = "",
    @ColumnInfo(name = "address")
    val address: String = "",
    @ColumnInfo(name = "id_number")
    val idNumber: String = "",
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String = ""
)
