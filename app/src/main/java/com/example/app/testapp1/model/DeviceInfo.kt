package com.example.app.testapp1.model

data class DeviceInfo(
    val name: String,
    val type: String,
    val status: DeviceStatus,
    val mac: String,
    val subscriptions: String
)