package org.sopt.at.presentation.signin

import androidx.annotation.StringRes

sealed class SignInSideEffect {
    data object NavigateUp: SignInSideEffect()

    data class NavigateMy(
        val id: String,
        val password: String
    ): SignInSideEffect()

    data object NavigateSignUp: SignInSideEffect()

    data class SnackBar (@StringRes val message: Int): SignInSideEffect()
}