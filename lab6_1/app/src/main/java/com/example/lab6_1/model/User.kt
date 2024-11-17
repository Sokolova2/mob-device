package com.example.lab6_1.model

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
)