package com.vic.android.financialapp.di

import com.vic.android.financialapp.data.repository.UserRepositoryImpl
import com.vic.android.financialapp.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        repository: UserRepositoryImpl
    ): UserRepository
}