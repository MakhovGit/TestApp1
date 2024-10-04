package com.example.app.testapp1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.testapp1.ui.screens.main_screen.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.MainScreen.route
    ) {
        composable(route = NavigationItem.MainScreen.route) {
            MainScreen(navController = navController)
        }
    }
}