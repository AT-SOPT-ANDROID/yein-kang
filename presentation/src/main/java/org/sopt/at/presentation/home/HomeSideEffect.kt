package org.sopt.at.presentation.home

sealed class HomeSideEffect {
    data object NavigateMy: HomeSideEffect()
}
