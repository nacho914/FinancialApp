package com.vic.android.financialapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vic.android.financialapp.ui.screens.users.UserScreen

@Composable
fun FinancialApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.User.route,
    ) {
        composable(Screen.User.route) {
            UserScreen(
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FinancialAppPreview() {
    FinancialApp()
}
