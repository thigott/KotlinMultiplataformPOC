package com.thigott.kotlinmultiplataformpoc.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thigott.kotlinmultiplataformpoc.home.R
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeViewAction.Login
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeViewAction.UpdatePassword
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeViewAction.UpdateUsername
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val viewState = viewModel.viewState

    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            HomeContent(
                isLoading = viewState.isLoading,
                username = viewState.username,
                password = viewState.password,
                error = viewState.error,
                viewAction = viewModel::dispatchViewAction
            )
        }
    }
}

@Composable
private fun HomeContent(
    isLoading: Boolean = false,
    username: String = "",
    password: String = "",
    error: String = "",
    viewAction: (HomeViewAction) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HomeInputData(
            value = username,
            onValueChange = { viewAction(UpdateUsername(it)) },
            hint = stringResource(R.string.username_hint)
        )
        Spacer(modifier = Modifier.height(8.dp))
        HomeInputData(
            value = password,
            onValueChange = { viewAction(UpdatePassword(it)) },
            hint = stringResource(R.string.password_hint)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = Color.Red
                )
            }
            Button(onClick = { viewAction(Login) }) {
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = stringResource(R.string.login)
                )
            }
        }
    }
}

@Composable
private fun HomeInputData(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = hint)
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            HomeContent()
        }
    }
}