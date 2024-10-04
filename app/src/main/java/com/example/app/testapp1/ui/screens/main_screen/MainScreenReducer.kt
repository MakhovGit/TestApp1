package com.example.app.testapp1.ui.screens.main_screen

import com.example.app.testapp1.ui.base.reducer.ReducerAbstract

class MainScreenReducer : ReducerAbstract<MainScreenContract.State, Any>() {

    override fun reduce(
        currentState: MainScreenContract.State,
        result: Any
    ): MainScreenContract.State {
        return when (result) {
            is Any -> currentState
            else -> currentState
        }
    }
}