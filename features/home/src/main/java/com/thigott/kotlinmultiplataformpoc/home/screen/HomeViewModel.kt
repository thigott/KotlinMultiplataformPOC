package com.thigott.kotlinmultiplataformpoc.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(), KoinComponent {

    private val getKtorTestUseCase by inject<GetKtorTestUseCase>()
    var viewState by mutableStateOf(HomeViewState())
        private set

    init {
        getKtor()
    }

    private fun getKtor() {
        viewState = viewState.copy(isLoading = true)
        getKtorTestUseCase(
            onSuccess = {
                viewState = viewState.copy(
                    isLoading = false,
                    requestData = it
                )
            },
            onError = {
                viewState = viewState.copy(isLoading = false)
            }
        )
    }
}