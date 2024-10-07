package com.example.app.testapp1.ui.screens.messages_screen

import com.example.app.testapp1.model.TextMessage
import com.example.app.testapp1.ui.base.ViewEvent
import com.example.app.testapp1.ui.base.ViewState

class MessagesScreenContract {
    data class State(
        val data: List<TextMessage> = listOf()
    ) : ViewState

    sealed class Event : ViewEvent {
        data class SaveMessage(
            val message: TextMessage
        ) : Event()
    }
}