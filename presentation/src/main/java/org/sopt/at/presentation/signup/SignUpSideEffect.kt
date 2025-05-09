package org.sopt.at.presentation.signup

import androidx.annotation.StringRes

sealed class SignUpSideEffect {
    data object NavigateUp : SignUpSideEffect()

    data object NavigateSignIn : SignUpSideEffect()

    data class SnackBar(@StringRes val message: Int) : SignUpSideEffect()

    data class SnackBarMessage(val message: String) : SignUpSideEffect()
}