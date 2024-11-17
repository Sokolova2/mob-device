package com.example.lab6_1.interfaces

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Loader() {
    CircularProgressIndicator(
        color = Color.DarkGray
    )
}