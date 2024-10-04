package com.example.app.testapp1.ui.base.state_holder

import com.example.app.testapp1.ui.base.reducer.Reducer

abstract class StateHolderAbstract<S, R>(
    private val reducer: Reducer<S, R>
) : StateHolder<S, R> {
    abstract override val screenState: S
    abstract override fun update(result: R)
}