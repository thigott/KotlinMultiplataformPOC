package com.thigott.kotlinmultiplataformpoc.di
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeViewModel
import com.thigott.kotlinmultiplataformpoc.profile.screen.ProfileViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { androidContext() }

    viewModel {
        HomeViewModel()
    }

    viewModel {
        ProfileViewModel()
    }
}