package org.sopt.at.presentation.signup

import org.sopt.at.entity.SignInEntity

data class SignUpState(
    val uiState: SignInEntity = SignInEntity(),
    val isIdScreen: Boolean = true
) {
    val isIdEnabled: Boolean = uiState.id.isNotEmpty()
    val isPasswordEnabled: Boolean = uiState.password.isNotEmpty()
}
