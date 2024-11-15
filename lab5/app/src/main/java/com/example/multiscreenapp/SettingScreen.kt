package com.example.multiscreenapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.background

@Composable
fun SettingScreen(navController: NavController, isDarkMode: Boolean, onToggleDarkMode: (Boolean) -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ){
        Text(text = "Setting", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Dark Mode", color = MaterialTheme.colorScheme.onBackground)
        Switch(
            checked = isDarkMode,
            onCheckedChange = { newState ->
                onToggleDarkMode(newState)
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Home")
        }
    }
}