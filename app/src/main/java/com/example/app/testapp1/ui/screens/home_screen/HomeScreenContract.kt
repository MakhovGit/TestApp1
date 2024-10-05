package com.example.app.testapp1.ui.screens.home_screen

import com.example.app.testapp1.ui.base.ViewEvent
import com.example.app.testapp1.ui.base.ViewState

class HomeScreenContract {
    data class State(
        val isDataLoading: Boolean = false
    ) : ViewState

    sealed class Event : ViewEvent {

    }
}