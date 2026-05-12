package com.vic.android.financialapp.navigation

sealed class Screen(val route: String) {
    data object User : Screen("user")
}