package org.sopt.at.presentation.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    MyScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp
    )
}

@Composable
fun MyScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "My",
        modifier = modifier
    )
}
