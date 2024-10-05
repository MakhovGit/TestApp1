package com.example.app.testapp1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.testapp1.ui.screens.apparatuses_screen.ApparatusesScreen
import com.example.app.testapp1.ui.screens.devs_screen.DevsScreen
import com.example.app.testapp1.ui.screens.home_screen.HomeScreen
import com.example.app.testapp1.ui.screens.messages_screen.MessagesScreen
import com.example.app.testapp1.ui.screens.settings_screen.SettingsScreen
import com.example.app.testapp1.ui.screens.statistics_screen.StatisticsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.HomeScreen.route
    ) {
        composable(route = NavigationItem.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.DevsScreen.route) {
            DevsScreen(navController = navController)
        }
        composable(route = NavigationItem.ApparatusesScreen.route) {
            ApparatusesScreen(navController = navController)
        }
        composable(route = NavigationItem.MessagesScreen.route) {
            MessagesScreen(navController = navController)
        }
        composable(route = NavigationItem.StatisticsScreen.route) {
            StatisticsScreen(navController = navController)
        }
        composable(route = NavigationItem.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
    }
}