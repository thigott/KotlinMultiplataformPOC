package com.thigott.kotlinmultiplataformpoc.home.screen

sealed class HomeViewAction {

    data class UpdateUsername(val username: String) : HomeViewAction()
    data class UpdatePassword(val password: String) : HomeViewAction()
    object Login : HomeViewAction()

    object Navigation {
        object NavigateToProfile : HomeViewAction()
    }
}