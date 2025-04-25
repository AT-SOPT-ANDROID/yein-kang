package org.sopt.at.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.MainTabRoute
import org.sopt.at.presentation.main.Route

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(
        route = MainTabRoute.Home,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            paddingValues = paddingValues
        )
    }
}