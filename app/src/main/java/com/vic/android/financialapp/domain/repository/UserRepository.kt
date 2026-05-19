package com.vic.android.financialapp.domain.repository

import com.vic.android.financialapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>

    suspend fun insertUser(user: User)
}