package com.vic.android.financialapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val firstName: String,
    val lastName: String,
    val createdAt: Long,
    val updatedAt: Long,
)