package com.example.app.testapp1.ui.screens._elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.app.testapp1.R
import com.example.app.testapp1.ui.navigation.NavigationItem

@Composable
fun NavigationBar(navList: List<NavigationItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        navList.forEach { item ->
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text(
                    text = item.name,
                    fontSize = dimensionResource(R.dimen.bottom_navigation_bar_font_size).value.sp,
                    color = if (currentRoute == item.route) Color.Blue else Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navList1 = listOf(
        NavigationItem.HomeScreen,
        NavigationItem.DevsScreen,
        NavigationItem.ApparatusesScreen
    )
    val navList2 = listOf(
        NavigationItem.MessagesScreen,
        NavigationItem.StatisticsScreen,
        NavigationItem.SettingsScreen
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.common_padding_10))
    ) {
        NavigationBar(navList = navList1, navController = navController)
        NavigationBar(navList = navList2, navController = navController)
    }
}
