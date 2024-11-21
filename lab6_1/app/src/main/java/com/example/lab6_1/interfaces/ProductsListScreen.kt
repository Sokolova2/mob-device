package com.example.lab6_1.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import com.example.lab6_1.viewmodel.ProductsViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CircularProgressIndicator
import com.example.lab6_1.model.Product
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background


@Composable
fun ProductsListScreen(productsViewModel: ProductsViewModel) {
    val products = productsViewModel.productsList
    val error = productsViewModel.errorMessage
    val isLoading = productsViewModel.isLoading.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            UpdatePage(productsViewModel = productsViewModel)
        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.Gray)
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                ) {
                    if (error.isNotEmpty()) {
                        item {
                            ErrorMessage(error)
                        }
                    } else {
                        items(products) { product ->
                            ProductsItem(product)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorMessage(error: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = error,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}