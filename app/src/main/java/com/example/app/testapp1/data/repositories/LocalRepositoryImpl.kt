package com.example.app.testapp1.data.repositories

import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.model.DeviceStatus
import com.example.app.testapp1.model.TextMessage

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

    private val messageList = mutableListOf(
        TextMessage(
            id = 104,
            author = "Dmitrii",
            recipient = "Anatolii",
            dateTime = 1670064247000,
            text = "Go to the piste 6"
        ),
        TextMessage(
            id = 105,
            author = "Dmitrii",
            recipient = "Dmitrii",
            dateTime = 1670063180000,
            text = "CAM-06 is down"
        ),
        TextMessage(
            id = 244,
            author = "Dmitrii",
            recipient = "Dmitrii",
            dateTime = 1670066647000,
            text = "Check CAM-05"
        ),
        TextMessage(
            id = 245,
            author = "Dmitrii",
            recipient = "Dmitrii",
            dateTime = 1670066780000,
            text = "Approve all LivedData"
        )
    )

    override fun getDeviceInfo(): List<DeviceInfo> = deviceList
    override fun getMessages(): List<TextMessage> = messageList.sortedByDescending { it.id }
    override fun saveMessage(message: TextMessage) {
        messageList.add(message)
    }
}