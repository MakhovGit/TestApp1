package com.example.app.testapp1.ui.screens.home_screen

import com.example.app.testapp1.ui.base.viewmodel.BaseViewModelAbstract

class HomeScreenViewModel(
    private val stateHolder: HomeScreenStateHolder
) : BaseViewModelAbstract<HomeScreenContract.State, HomeScreenContract.Event, Any>(stateHolder) {
    override val errorMessage: String = "MainViewModel error!"
    override fun handleEvent(event: HomeScreenContract.Event) {

    }
}