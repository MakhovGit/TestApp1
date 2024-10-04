package com.example.app.testapp1.ui.base.state_holder

interface StateHolder<S, R> {
    val screenState: S
    fun update(result: R)
}