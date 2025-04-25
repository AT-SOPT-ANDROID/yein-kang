package org.sopt.at.presentation.history

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.MainTabRoute

fun NavController.navigateToHistory(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.History,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.historyNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.History> {
        HistoryRoute(
            paddingValues = paddingValues
        )
    }
}