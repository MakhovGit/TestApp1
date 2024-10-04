package com.example.app.testapp1.di

import com.example.app.testapp1.ui.screens.main_screen.MainScreenReducer
import com.example.app.testapp1.ui.screens.main_screen.MainScreenStateHolder
import com.example.app.testapp1.ui.screens.main_screen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appKoinModule = module {
    singleOf(::MainScreenReducer)
    singleOf(::MainScreenStateHolder)
    viewModelOf(::MainScreenViewModel)
}