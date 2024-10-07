package com.example.app.testapp1.ui.screens.messages_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.app.testapp1.data.repositories.LocalRepository

class MessagesScreenViewModel(
    private val repository: LocalRepository
) : ViewModel() {
    var screenState by mutableStateOf(MessagesScreenContract.State())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        screenState = screenState.copy(data = repository.getMessages())
    }

    fun handleEvent(event: MessagesScreenContract.Event) {
        when (event) {
            is MessagesScreenContract.Event.SaveMessage -> {
                repository.saveMessage(event.message)
                screenState = screenState.copy(data = repository.getMessages())
            }
        }
    }
}