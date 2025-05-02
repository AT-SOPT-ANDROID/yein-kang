package org.sopt.at.presentation.main

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object SignIn : Route

    @Serializable
    data object SignUp : Route

    @Serializable
    data object My : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Shorts : MainTabRoute

    @Serializable
    data object Live : MainTabRoute

    @Serializable
    data object Search : MainTabRoute

    @Serializable
    data object History : MainTabRoute
}
