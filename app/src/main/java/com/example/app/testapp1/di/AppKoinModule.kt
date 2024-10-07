package com.example.app.testapp1.di

import com.example.app.testapp1.data.repositories.LocalRepository
import com.example.app.testapp1.data.repositories.LocalRepositoryImpl
import com.example.app.testapp1.ui.screens.devs_screen.DevsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appKoinModule = module {
    single<LocalRepository> { LocalRepositoryImpl() }
    viewModelOf(::DevsScreenViewModel)
}