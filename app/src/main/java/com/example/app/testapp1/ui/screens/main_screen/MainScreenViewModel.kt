package com.example.app.testapp1.ui.screens.main_screen

import com.example.app.testapp1.ui.base.viewmodel.BaseViewModelAbstract

class MainScreenViewModel(
    private val stateHolder: MainScreenStateHolder
) : BaseViewModelAbstract<MainScreenContract.State, MainScreenContract.Event, Any>(stateHolder) {
    override val errorMessage: String = "MainViewModel error!"
    override fun handleEvent(event: MainScreenContract.Event) {

    }
}