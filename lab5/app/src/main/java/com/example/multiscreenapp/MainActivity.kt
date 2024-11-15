package com.example.multiscreenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHost
import androidx.navigation.compose.*
import com.example.multiscreenapp.ui.theme.MultiScreenAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkMode by remember { mutableStateOf(false)}

            MultiScreenAppTheme(darkTheme = isDarkMode) {
                AppNavigation(isDarkMode) { newMode ->
                    isDarkMode = newMode
                }
            }
        }
    }
}

@Composable
fun AppNavigation(isDarkMode: Boolean, onToggleDarkMode: (Boolean) -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("details/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            DetailsScreen(navController, itemId)
        }
        composable("setting") {
            SettingScreen(navController, isDarkMode, onToggleDarkMode)
        }
    }
}
