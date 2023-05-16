package com.thigott.kotlinmultiplataformpoc.di
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        HomeViewModel()
    }
}