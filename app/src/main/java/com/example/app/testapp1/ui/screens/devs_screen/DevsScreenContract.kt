package com.example.app.testapp1.ui.screens.devs_screen

import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.ui.base.ViewEvent
import com.example.app.testapp1.ui.base.ViewState

class DevsScreenContract {
    data class State(
        val data: List<DeviceInfo> = listOf()
    ) : ViewState

    sealed class Event : ViewEvent {

    }
}