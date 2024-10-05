package com.example.app.testapp1.ui.navigation

sealed class NavigationItem(val route: String, val name: String) {
    data object HomeScreen : NavigationItem("home_screen", "Home")
    data object DevsScreen : NavigationItem("devs_screen", "Devs")
    data object ApparatusesScreen : NavigationItem("apparatuses_screen", "Apparatuses")
    data object MessagesScreen : NavigationItem("messages_screen", "Messages")
    data object StatisticsScreen : NavigationItem("statistics_screen", "Statistics")
    data object SettingsScreen : NavigationItem("settings_screen", "Settings")
}