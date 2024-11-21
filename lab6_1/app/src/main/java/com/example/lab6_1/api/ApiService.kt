package com.example.lab6_1.api

import com.example.lab6_1.model.Product
import io.ktor.client.call.body
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchProducts(): List<Product> {
    return withContext(Dispatchers.IO) {
        client.get("https://fakestoreapi.com/products").body()
    }
}
