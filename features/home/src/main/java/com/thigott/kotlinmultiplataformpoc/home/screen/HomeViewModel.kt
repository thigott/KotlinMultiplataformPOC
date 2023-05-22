package com.thigott.kotlinmultiplataformpoc.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(), KoinComponent {

    private val loginUseCase by inject<LoginUseCase>()
    var viewState by mutableStateOf(HomeViewState())
        private set


    fun updateUsernameValue(username: String) {
        viewState = viewState.copy(
            username = username
        )
    }

    fun updatePasswordValue(password: String) {
        viewState = viewState.copy(
            password = password
        )
    }

    fun login() {
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
                    success = it.accessToken
                )
            },
            onError = {
                viewState = viewState.copy(
                    isLoading = false,
                    error = it.message ?: ""
                )
            }
        )
    }
}