package com.example.app.testapp1.model

data class TextMessage(
    val id: Long,
    val dateTime: Long,
    val author: String,
    val recipient: String,
    val text: String
)