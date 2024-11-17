package com.example.lab6_1.api

import com.example.lab6_1.model.User
import io.ktor.client.call.body
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchUsers(): List<User> {
    return withContext(Dispatchers.IO) {
        client.get("https://jsonplaceholder.typicode.com/users").body()
    }
}