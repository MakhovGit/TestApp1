package com.example.app.testapp1.ui.base.viewmodel

interface BaseViewModel<S, E> {
    val screenState: S
    fun handleEvent(event: E)
}