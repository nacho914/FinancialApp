package com.vic.android.financialapp.ui.screens.addUser

sealed interface AddUserEvent {
    data object UserSaved : AddUserEvent
}