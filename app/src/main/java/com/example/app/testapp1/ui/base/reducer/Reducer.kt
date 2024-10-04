package com.example.app.testapp1.ui.base.reducer

interface Reducer<S, R> {
    fun reduce(currentState: S, result: R): S
}