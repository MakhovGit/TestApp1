package com.example.app.testapp1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.app.testapp1.ui.navigation.AppNavigation
import com.example.app.testapp1.ui.theme.Single_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Single_ComposeTheme {
                AppNavigation()
            }
        }
    }
}
