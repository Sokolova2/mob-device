package com.example.lab6_1.model

import kotlinx.serialization.Serializable


@Serializable
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String
)
