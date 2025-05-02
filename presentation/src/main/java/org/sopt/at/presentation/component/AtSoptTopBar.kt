package org.sopt.at.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.R
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun AtSoptTopBar(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AtSoptTheme.colors.backgroundPrimary,
    iconColor: Color = AtSoptTheme.colors.textPrimary,
    trailingIcons: @Composable () -> Unit = {}
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowLeft,
            contentDescription = stringResource(R.string.back_button),
            modifier = Modifier
                .size(40.dp)
                .noRippleClickable(
                    onClick = onBackButtonClick
                ),
            tint = iconColor
        )

        Spacer(Modifier.weight(1f))

        trailingIcons()

    }
}

@Composable
@Preview
fun AtSoptTopBarPreview() {
    AtSoptAndroidTheme {
        AtSoptTopBar(
            onBackButtonClick = {}
        )
    }
}
