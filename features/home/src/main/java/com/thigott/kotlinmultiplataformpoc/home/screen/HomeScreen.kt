package com.thigott.kotlinmultiplataformpoc.home.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thigott.kotlinmultiplataformpoc.home.R
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val viewState = viewModel.viewState

    if (viewState.success.isNotEmpty()) {
        Toast.makeText(LocalContext.current, viewState.success, Toast.LENGTH_SHORT).show()
    }

    if (viewState.error.isNotEmpty()) {
        Toast.makeText(LocalContext.current, viewState.error, Toast.LENGTH_SHORT).show()
    }

    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            HomeContent(
                isLoading = viewState.isLoading,
                username = viewState.username,
                password = viewState.password,
                onUsernameChange = viewModel::updateUsernameValue,
                onPasswordChange = viewModel::updatePasswordValue,
                onButtonClicked = viewModel::login
            )
        }
    }
}

@Composable
private fun HomeContent(
    isLoading: Boolean = false,
    username: String = "",
    password: String = "",
    onUsernameChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HomeInputData(
            value = username,
            onValueChange = onUsernameChange,
            hint = stringResource(R.string.username_hint)
        )
        Spacer(modifier = Modifier.height(8.dp))
        HomeInputData(
            value = password,
            onValueChange = onPasswordChange,
            hint = stringResource(R.string.password_hint)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(onClick = onButtonClicked) {
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