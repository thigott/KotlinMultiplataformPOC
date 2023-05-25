package com.thigott.kotlinmultiplataformpoc.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val homeNavigation by inject<HomeNavigation>()
    private val loginUseCase by inject<LoginUseCase>()
    var viewState by mutableStateOf(HomeViewState())
        private set

    fun dispatchViewAction(viewAction: HomeViewAction) {
        when (viewAction) {
            is HomeViewAction.UpdateUsername -> updateUsernameValue(username = viewAction.username)
            is HomeViewAction.UpdatePassword -> updatePasswordValue(password = viewAction.password)
            is HomeViewAction.Login -> login()
            is HomeViewAction.Navigation.NavigateToProfile -> navigateToProfileScreen()
        }
    }

    private fun updateUsernameValue(username: String) {
        viewState = viewState.copy(
            username = username,
            error = "",
            success = ""
        )
    }

    private fun updatePasswordValue(password: String) {
        viewState = viewState.copy(
            password = password,
            error = "",
            success = ""
        )
    }

    private fun login() {
        viewState = viewState.copy(
            isLoading = true
        )

        loginUseCase(
            params = LoginUseCase.Params(
                username = viewState.username,
                password = viewState.password
            ),
            onSuccess = {
                viewState = viewState.copy(
                    isLoading = false,
                    success = it.accessToken,
                    error = ""
                )

                dispatchViewAction(HomeViewAction.Navigation.NavigateToProfile)
            },
            onError = {
                viewState = viewState.copy(
                    isLoading = false,
                    error = it.message ?: "",
                    success = ""
                )
            }
        )
    }

    private fun navigateToProfileScreen() {
        homeNavigation.goToProfileScreen()
    }
}