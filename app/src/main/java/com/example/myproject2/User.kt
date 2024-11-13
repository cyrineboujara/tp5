package com.example.myproject2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey val uid: Int,
    val firstName: String,
    val lastName: String
)
