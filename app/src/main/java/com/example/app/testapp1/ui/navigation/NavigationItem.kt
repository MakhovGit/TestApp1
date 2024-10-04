package com.example.app.testapp1.ui.navigation

sealed class NavigationItem(var route: String) {
    data object MainScreen : NavigationItem("main_screen")
}