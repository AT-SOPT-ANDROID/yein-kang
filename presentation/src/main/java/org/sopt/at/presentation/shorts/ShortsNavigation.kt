package org.sopt.at.presentation.shorts

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.MainTabRoute

fun NavController.navigateToShorts(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Shorts,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.shortsNavGraph(
    paddingValues: PaddingValues
) {
    composable<MainTabRoute.Shorts> {
        ShortsRoute(
            paddingValues = paddingValues,
        )
    }
}
