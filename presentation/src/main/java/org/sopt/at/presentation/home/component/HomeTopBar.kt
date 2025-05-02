package org.sopt.at.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.R
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onClickProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.tving),
                contentDescription = stringResource(R.string.tving),
                modifier = Modifier.height(32.dp)
            )
        },
        actions = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.cast_icon),
                contentDescription = stringResource(R.string.icon_cast),
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 8.dp)
                    .noRippleClickable(
                        onClick = {

                        }
                    )
            )
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = stringResource(R.string.profile),
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 8.dp)
                    .noRippleClickable(
                        onClick = {
                            onClickProfile()
                        }
                    )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AtSoptTheme.colors.backgroundPrimary,
            titleContentColor = AtSoptTheme.colors.textPrimary,
            actionIconContentColor = AtSoptTheme.colors.textPrimary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun HomeTopBarPreview() {
    AtSoptAndroidTheme {
        HomeTopBar(
            onClickProfile = {}
        )
    }
}