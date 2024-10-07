package com.example.app.testapp1.di

import com.example.app.testapp1.data.repositories.LocalRepository
import com.example.app.testapp1.data.repositories.LocalRepositoryImpl
import com.example.app.testapp1.ui.screens.devs_screen.DevsScreenViewModel
import com.example.app.testapp1.ui.screens.messages_screen.MessagesScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    single<LocalRepository> { LocalRepositoryImpl() }
    viewModel<DevsScreenViewModel> { DevsScreenViewModel(repository = get()) }
    viewModel<MessagesScreenViewModel> { MessagesScreenViewModel(repository = get()) }
}