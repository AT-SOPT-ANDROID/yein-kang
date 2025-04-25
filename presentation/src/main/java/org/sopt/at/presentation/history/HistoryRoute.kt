package org.sopt.at.presentation.history

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HistoryRoute(
    paddingValues: PaddingValues,
) {
    HistoryScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun HistoryScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Text(
        text = "History",
        modifier = modifier
    )
}