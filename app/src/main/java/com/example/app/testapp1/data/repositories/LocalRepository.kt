package com.example.app.testapp1.data.repositories

import com.example.app.testapp1.model.DeviceInfo

interface LocalRepository {
    fun getDeviceInfo(): List<DeviceInfo>
}