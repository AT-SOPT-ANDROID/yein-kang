package org.sopt.at.presentation.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.Route

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    navigate(
        route = Route.My,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.myNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.My> {
        MyRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp
        )
    }
}
