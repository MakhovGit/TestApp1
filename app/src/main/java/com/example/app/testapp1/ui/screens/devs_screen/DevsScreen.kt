package com.example.app.testapp1.ui.screens.devs_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.app.testapp1.R
import com.example.app.testapp1.ui.screens._elements.Dummy

@Composable
fun DevsScreen(
    navController: NavHostController
) {
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Dummy(
                    title = stringResource(R.string.devs_screen_title),
                    navController = navController
                )
            }
        }
    )
}