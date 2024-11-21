package com.example.lab6_1.interfaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab6_1.viewmodel.ProductsViewModel

@Composable
fun MainScreen() {
    val productsViewModel: ProductsViewModel = viewModel()

    Column(modifier = Modifier.padding(15.dp)) {
        ProductsListScreen(productsViewModel = productsViewModel)
    }
}