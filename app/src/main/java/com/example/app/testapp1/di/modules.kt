package com.example.app.testapp1.di

import com.example.app.testapp1.ui.screens.home_screen.HomeScreenReducer
import com.example.app.testapp1.ui.screens.home_screen.HomeScreenStateHolder
import com.example.app.testapp1.ui.screens.home_screen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appKoinModule = module {
    singleOf(::HomeScreenReducer)
    singleOf(::HomeScreenStateHolder)
    viewModelOf(::HomeScreenViewModel)
}