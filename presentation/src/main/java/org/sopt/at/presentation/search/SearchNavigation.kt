package org.sopt.at.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.MainTabRoute

fun NavController.navigateToSearch(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Search,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.searchNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.Search> {
        SearchRoute(
            paddingValues = paddingValues
        )
    }
}
