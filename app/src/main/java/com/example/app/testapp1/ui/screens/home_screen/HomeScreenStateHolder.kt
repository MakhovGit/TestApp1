package com.example.app.testapp1.ui.screens.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.app.testapp1.ui.base.state_holder.StateHolderAbstract

class HomeScreenStateHolder(
    private val reducer: HomeScreenReducer
) : StateHolderAbstract<HomeScreenContract.State, Any>(reducer) {
    override var screenState by mutableStateOf(HomeScreenContract.State())
        private set

    override fun update(result: Any) {
        screenState = reducer.reduce(screenState, result)
    }

}