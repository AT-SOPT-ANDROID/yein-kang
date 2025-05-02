package org.sopt.at.presentation.signin

import androidx.annotation.StringRes

sealed class SignInSideEffect {
    data object NavigateUp: SignInSideEffect()

    data object NavigateHome: SignInSideEffect()

    data object NavigateSignUp: SignInSideEffect()

    data class SnackBar(@StringRes val message: Int): SignInSideEffect()
}