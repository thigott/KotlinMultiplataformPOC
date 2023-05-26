package com.thigott.kotlinmultiplataformpoc.profile.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetUserLoggedDataUseCase
import com.thigott.kotlinmultiplataformpoc.profile.screen.ProfileViewAction.GetUserLoggedData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileViewModel : ViewModel(), KoinComponent {

    private val getUserLoggedDataUseCase by inject<GetUserLoggedDataUseCase>()

    var viewState by mutableStateOf(ProfileViewState())
        private set

    init {
        dispatchViewAction(
            viewAction = GetUserLoggedData
        )
    }

    private fun dispatchViewAction(viewAction: ProfileViewAction) {
        when (viewAction) {
            is GetUserLoggedData -> getUserLoggedData()
        }
    }

    private fun getUserLoggedData() {
        viewState = viewState.copy(isLoading = true)

        getUserLoggedDataUseCase(
            onSuccess = {
                viewState = viewState.copy(
                    isLoading = false,
                    error = null,
                    userModel = it
                )
            },
            onError = {
                viewState = viewState.copy(
                    isLoading = false,
                    userModel = null,
                    error = it.message
                )
            }
        )
    }
}