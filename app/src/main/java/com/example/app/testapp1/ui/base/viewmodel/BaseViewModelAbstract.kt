package com.example.app.testapp1.ui.base.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.app.testapp1.settings.MAIN_LOG_TAG
import com.example.app.testapp1.ui.base.state_holder.StateHolder
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModelAbstract<S, E, R>(
    private val stateHolder: StateHolder<S, R>
) : ViewModel(), BaseViewModel<S, E> {
    override val screenState: S
        get() = stateHolder.screenState
    abstract val errorMessage: String
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, error ->
        Log.e(MAIN_LOG_TAG, "$errorMessage ${error.message}.")
        error.printStackTrace()
    }
    val mainScope =
        CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)

    abstract override fun handleEvent(event: E)
}