package com.example.lab6_1.interfaces

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6_1.model.User


@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(CornerSize(15.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            Text(
                text = user.username,
                style = TextStyle(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Name: ${user.name}",
                style = TextStyle(fontSize = 16.sp, color = Color.DarkGray)
            )

            Text(
                text = "Email: ${user.email}",
                style = TextStyle(fontSize = 16.sp, color = Color.DarkGray)
            )
        }
    }
}