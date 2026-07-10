package com.vic.android.financialapp.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)