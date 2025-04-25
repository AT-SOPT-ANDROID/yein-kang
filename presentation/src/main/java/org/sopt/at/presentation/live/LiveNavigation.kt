package org.sopt.at.presentation.live

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.MainTabRoute
import org.sopt.at.presentation.main.Route

fun NavController.navigateToLive(navOptions: NavOptions){
    navigate(
        route = MainTabRoute.Live,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.liveNavGraph(
    paddingValues: PaddingValues,
){
    composable<MainTabRoute.Live> {
        LiveRoute(
            paddingValues = paddingValues
        )
    }
}