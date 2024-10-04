package com.example.app.testapp1.ui.screens.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.app.testapp1.ui.base.state_holder.StateHolderAbstract

class MainScreenStateHolder(
    private val reducer: MainScreenReducer
) : StateHolderAbstract<MainScreenContract.State, Any>(reducer) {
    override var screenState by mutableStateOf(MainScreenContract.State())
        private set

    override fun update(result: Any) {
        screenState = reducer.reduce(screenState, result)
    }

}