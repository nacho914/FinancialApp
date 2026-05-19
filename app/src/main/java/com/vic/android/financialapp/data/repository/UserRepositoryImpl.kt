package com.vic.android.financialapp.data.repository

import com.vic.android.financialapp.data.local.dao.UserDao
import com.vic.android.financialapp.data.mapper.toDomain
import com.vic.android.financialapp.data.mapper.toEntity
import com.vic.android.financialapp.domain.model.User
import com.vic.android.financialapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override fun getUsers(): Flow<List<User>> =
        userDao.getUsers().map { users -> users.map { it.toDomain() } }


    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toEntity())
    }
}