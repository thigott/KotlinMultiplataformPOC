package com.thigott.kotlinmultiplataformpoc.profile.screen

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel

data class ProfileViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val userModel: UserModel? = null
)