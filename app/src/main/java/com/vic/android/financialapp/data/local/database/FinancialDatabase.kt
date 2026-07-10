package com.vic.android.financialapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vic.android.financialapp.data.local.dao.UserDao
import com.vic.android.financialapp.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 2,
    exportSchema = false,
)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}