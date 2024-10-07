package com.example.app.testapp1.data.repositories

import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.model.TextMessage

interface LocalRepository {
    fun getDeviceInfo(): List<DeviceInfo>
    fun getMessages(): List<TextMessage>
    fun saveMessage(message: TextMessage)
}