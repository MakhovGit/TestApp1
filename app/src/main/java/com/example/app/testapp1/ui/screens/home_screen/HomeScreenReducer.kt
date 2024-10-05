package com.example.app.testapp1.ui.screens.home_screen

import com.example.app.testapp1.ui.base.reducer.ReducerAbstract

class HomeScreenReducer : ReducerAbstract<HomeScreenContract.State, Any>() {

    override fun reduce(
        currentState: HomeScreenContract.State,
        result: Any
    ): HomeScreenContract.State {
        return when (result) {
            is Any -> currentState
            else -> currentState
        }
    }
}