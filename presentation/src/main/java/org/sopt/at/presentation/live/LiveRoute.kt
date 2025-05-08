package org.sopt.at.presentation.live

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LiveRoute(
    paddingValues: PaddingValues
) {
    LiveScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun LiveScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Live",
        modifier = modifier
    )
}
