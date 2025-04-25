package org.sopt.at.presentation.signup

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.Route

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) {
    navigate(
        route = Route.SignUp,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signUpNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateSignIn: () -> Unit
) {
    composable<Route.SignUp> {
        SignUpRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateSignIn = navigateSignIn,
        )

    }
}