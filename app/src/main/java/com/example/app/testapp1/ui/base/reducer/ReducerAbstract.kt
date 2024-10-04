package com.example.app.testapp1.ui.base.reducer

abstract class ReducerAbstract<S, R> : Reducer<S, R> {
    abstract override fun reduce(currentState: S, result: R): S
}