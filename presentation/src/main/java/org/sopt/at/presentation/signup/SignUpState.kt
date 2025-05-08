package org.sopt.at.presentation.signup

import org.sopt.at.entity.SignUpEntity

data class SignUpState(
    val uiState: SignUpEntity = SignUpEntity(),
    val screenType: ScreenType = ScreenType.ID
) {
    val isIdEnabled: Boolean = uiState.loginId.isNotEmpty()
    val isPasswordEnabled: Boolean = uiState.password.isNotEmpty()
    val isNicknameEnabled: Boolean = uiState.nickname.isNotEmpty()
}
