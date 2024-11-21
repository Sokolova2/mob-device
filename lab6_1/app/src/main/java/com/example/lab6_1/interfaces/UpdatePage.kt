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
import com.example.lab6_1.viewmodel.ProductsViewModel
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box


@Composable
fun UpdatePage(productsViewModel: ProductsViewModel) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Button(
            onClick = {
                productsViewModel.fetchProductList()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "Update",
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.LightGray
                )
            )
        }
    }
}