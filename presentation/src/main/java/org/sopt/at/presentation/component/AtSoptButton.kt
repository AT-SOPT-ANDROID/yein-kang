package org.sopt.at.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.R
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun AtSoptButton(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    isEnabled: Boolean = false,
    borderColor: Color = Color.Transparent
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontWeight = fontWeight
        ),
        color = if(isEnabled) AtSoptTheme.colors.textPrimary else AtSoptTheme.colors.textSecondary,
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(if(isEnabled) AtSoptTheme.colors.accentRed else backgroundColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(16.dp)
            .noRippleClickable(
                onClick = { if(isEnabled) onClick() }
            )
    )
}

@Preview(showBackground = true)
@Composable
fun AtSoptButtonPreview() {
    AtSoptAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AtSoptButton(
                text = stringResource(R.string.login),
                backgroundColor = AtSoptTheme.colors.dividerPrimary,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            AtSoptButton(
                text = stringResource(R.string.login),
                backgroundColor = AtSoptTheme.colors.dividerPrimary,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                isEnabled = true,
                fontWeight = FontWeight.Bold
            )
        }
    }
}