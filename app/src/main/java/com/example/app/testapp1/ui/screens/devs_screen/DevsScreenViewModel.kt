package com.example.app.testapp1.ui.screens.devs_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.app.testapp1.data.repositories.LocalRepository

class DevsScreenViewModel(
    private val repository: LocalRepository
) : ViewModel() {
    var screenState by mutableStateOf(DevsScreenContract.State())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        screenState = screenState.copy(data = repository.getDeviceInfo())
    }
}