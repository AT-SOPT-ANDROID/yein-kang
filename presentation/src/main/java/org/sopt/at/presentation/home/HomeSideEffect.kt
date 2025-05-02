package org.sopt.at.presentation.home

import org.sopt.at.presentation.signin.SignInSideEffect

sealed class HomeSideEffect {
    data object NavigateUp: HomeSideEffect()

    data object NavigateMy: HomeSideEffect()
}