package com.example.myproject2

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user_table WHERE uid = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): Flow<List<User>>  // Utilisation de Flow pour les mises à jour en direct
}
