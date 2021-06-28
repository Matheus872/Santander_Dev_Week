package com.example.santanderdevweek.data

data class Account(
    val number: String,
    val branch: String,
    val balance: String,
    val limit: String,
    val client: Client,
    val card: Card
) {}