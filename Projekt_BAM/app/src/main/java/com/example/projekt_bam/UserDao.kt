package com.example.projekt_bam

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): UserEntity?

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>
}
