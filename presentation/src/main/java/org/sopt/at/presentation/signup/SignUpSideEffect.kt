package org.sopt.at.presentation.signup

import androidx.annotation.StringRes

sealed class SignUpSideEffect {
    data object NavigateUp : SignUpSideEffect()

    data class NavigateSignIn(
        val id: String,
        val password: String
    ) : SignUpSideEffect()

    data class SnackBar(@StringRes val message: Int) : SignUpSideEffect()
}