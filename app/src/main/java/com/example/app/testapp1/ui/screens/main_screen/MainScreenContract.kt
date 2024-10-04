package com.example.app.testapp1.ui.screens.main_screen

import com.example.app.testapp1.ui.base.ViewEvent
import com.example.app.testapp1.ui.base.ViewState

class MainScreenContract {
    data class State(
        val isDataLoading: Boolean = false
    ) : ViewState

    sealed class Event : ViewEvent {

    }
}