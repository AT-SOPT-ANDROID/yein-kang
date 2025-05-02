package org.sopt.at.presentation.shorts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShortsRoute(
    paddingValues: PaddingValues,
) {
    ShortsScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun ShortsScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Shorts",
        modifier = modifier
    )
}
