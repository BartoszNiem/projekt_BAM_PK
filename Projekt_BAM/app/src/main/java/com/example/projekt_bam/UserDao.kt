package com.example.projekt_bam

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): UserEntity?

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users where email = :email and password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): UserEntity

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Long): UserEntity?
}
