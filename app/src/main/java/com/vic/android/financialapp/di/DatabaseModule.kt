package com.vic.android.financialapp.di

import android.content.Context
import androidx.room.Room
import com.vic.android.financialapp.data.local.dao.UserDao
import com.vic.android.financialapp.data.local.database.FinancialDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): FinancialDatabase {
        return Room.databaseBuilder(
            context,
            FinancialDatabase::class.java,
            "financial_database"
        ).build()
    }

    @Provides
    fun provideUserDao(
        database: FinancialDatabase,
    ): UserDao = database.userDao()
}