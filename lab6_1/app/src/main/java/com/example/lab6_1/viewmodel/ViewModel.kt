package com.example.lab6_1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.lab6_1.api.fetchProducts
import com.example.lab6_1.model.Product


class ProductsViewModel : ViewModel() {
    var productsList by mutableStateOf<List<Product>>(emptyList())
    var errorMessage by mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        fetchProductList()
    }

    fun fetchProductList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                productsList = fetchProducts()

            } catch (e: Exception) {
                Log.d("errorMessage", e.message.toString())
                errorMessage = "Failed to load data: ${e.message}"
            }
            finally {
                isLoading.value = false
            }
        }
    }
}