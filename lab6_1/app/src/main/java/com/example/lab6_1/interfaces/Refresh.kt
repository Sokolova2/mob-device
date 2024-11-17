package com.example.lab6_1.interfaces

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6_1.viewmodel.UserViewModel

@Composable
fun RefreshButton(userViewModel: UserViewModel) {
    Button(
        onClick = {
            userViewModel.fetchUserList()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Refresh", style = androidx.compose.ui.text.TextStyle(
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.LightGray
        ))
    }
}