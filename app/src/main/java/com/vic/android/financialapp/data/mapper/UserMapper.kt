package com.vic.android.financialapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.vic.android.financialapp.data.local.entity.UserEntity
import com.vic.android.financialapp.domain.model.User
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
fun UserEntity.toDomain(): User {
    return User(
        id = UUID.fromString(id),
        firstName = firstName,
        lastName = lastName,
        createdAt = Instant.ofEpochMilli(createdAt)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime(),
        updatedAt = Instant.ofEpochMilli(updatedAt)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime(),
    )
}