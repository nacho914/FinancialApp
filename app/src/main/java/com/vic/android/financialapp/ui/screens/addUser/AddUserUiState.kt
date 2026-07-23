package com.vic.android.financialapp.ui.screens.addUser

data class AddUserUiState(
    val firstName: String = "",
    val lastName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)
