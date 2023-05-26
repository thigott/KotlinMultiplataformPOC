package com.thigott.kotlinmultiplataformpoc.profile.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = getViewModel()
) {
    BackHandler {}

    val viewState = viewModel.viewState

    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            ProfileContent(
                isLoading = viewState.isLoading,
                error = viewState.error,
                userModel = viewState.userModel
            )
        }
    }
}

@Composable
private fun ProfileContent(
    isLoading: Boolean = false,
    userModel: UserModel? = null,
    error: String? = null
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator()
            }
            error.isNullOrEmpty().not() -> {
                Text(text = error.orEmpty())
            }
            userModel != null -> {
                Text(text = userModel.username)
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            ProfileContent(
                isLoading = true
            )
        }
    }
}