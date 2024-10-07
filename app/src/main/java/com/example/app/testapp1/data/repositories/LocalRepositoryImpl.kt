package com.example.app.testapp1.data.repositories

import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.model.DeviceStatus

class LocalRepositoryImpl : LocalRepository {
    private val deviceList = listOf(
        DeviceInfo(
            name = "Cam-5",
            type = "Camera",
            status = DeviceStatus.LIVE,
            mac = "fe:fe:f3:fe",
            subscriptions = "SM-03"
        ),
        DeviceInfo(
            name = "Rep-1",
            type = "Camera",
            status = DeviceStatus.DEAD,
            mac = "fe:fe:f3:fe",
            subscriptions = "SM-03"
        ),
        DeviceInfo(
            name = "LD-4",
            type = "LiveData",
            status = DeviceStatus.MUTE,
            mac = "fe:fe:f3:fe",
            subscriptions = "SM-03"
        ),
        DeviceInfo(
            name = "Dmitrii",
            type = "Participant",
            status = DeviceStatus.APPROVED,
            mac = "fe:fe:f3:fe",
            subscriptions = "no"
        )
    )

    override fun getDeviceInfo(): List<DeviceInfo> = deviceList
}