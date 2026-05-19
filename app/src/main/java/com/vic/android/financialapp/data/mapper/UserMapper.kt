package com.vic.android.financialapp.data.mapper

import com.vic.android.financialapp.data.local.entity.UserEntity
import com.vic.android.financialapp.domain.model.User

fun UserEntity.toDomain(): User {
    return User(id = id, name = name)
}

fun User.toEntity(): UserEntity {
    return UserEntity(id = id, name = name)
}