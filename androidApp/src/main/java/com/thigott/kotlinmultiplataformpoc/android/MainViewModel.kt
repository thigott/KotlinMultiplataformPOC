package com.thigott.kotlinmultiplataformpoc.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.NavigationCommand
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.NavigationManager
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val navigationManager: NavigationManager by inject()

    fun initNavigation(
        navHostController: NavHostController
    ) {
        viewModelScope.launch {
            navigationManager.commands.collect { command ->
                when (command) {
                    NavigationCommand.NavigateUp -> navHostController.navigateUp()
                    NavigationCommand.PopStackBack -> navHostController.popBackStack()
                    is NavigationCommand.Navigate -> navHostController.navigate(
                        route = command.destination,
                        navOptions = command.navOptions
                    )
                }
            }
        }
    }
}