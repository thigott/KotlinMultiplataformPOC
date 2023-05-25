package com.thigott.kotlinmultiplataformpoc.di

import com.thigott.kotlinmultiplataformpoc.home.screen.HomeNavigation
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.NavigationManager
import com.thigott.kotlinmultiplataformpoc.navigation.navigation.HomeNavigationImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(
            CoroutineScope(
                SupervisorJob() + Dispatchers.Main
            )
        )
    }

    single<HomeNavigation> {
        HomeNavigationImpl(
            navigationManager = get()
        )
    }
}