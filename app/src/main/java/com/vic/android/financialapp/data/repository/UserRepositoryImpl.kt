package com.vic.android.financialapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.vic.android.financialapp.data.local.dao.UserDao
import com.vic.android.financialapp.data.local.entity.UserEntity
import com.vic.android.financialapp.data.mapper.toDomain
import com.vic.android.financialapp.di.IoDispatcher
import com.vic.android.financialapp.domain.model.User
import com.vic.android.financialapp.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

class UserRepositoryImpl
    @Inject
    constructor(
        private val userDao: UserDao,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    ) : UserRepository {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getUsers(): Flow<List<User>> = userDao.getUsers().map { users -> users.map { it.toDomain() } }

        override suspend fun insertUser(
            firstName: String,
            lastName: String,
        ) = withContext(ioDispatcher) {
            userDao.insertUser(
                UserEntity(
                    id = UUID.randomUUID().toString(),
                    firstName = firstName,
                    lastName = lastName,
                    createdAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis(),
                ),
            )
        }

        override suspend fun deleteAllUsers() {
            userDao.deleteAllUsers()
        }

        override suspend fun deleteUser(id: String) =
            withContext(ioDispatcher) {
                userDao.deleteUser(id)
            }
    }
