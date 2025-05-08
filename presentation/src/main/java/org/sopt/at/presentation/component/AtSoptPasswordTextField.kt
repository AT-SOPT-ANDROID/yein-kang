package org.sopt.at.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.presentation.R
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme

@Composable
fun AtSoptPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPasswordVisible: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Done
    )
) {

    var isPasswordVisible by remember { mutableStateOf(isPasswordVisible) }

    AtSoptTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = stringResource(R.string.password),
        keyboardOptions = keyboardOptions,
        visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Image(
                imageVector = if(isPasswordVisible) ImageVector.vectorResource(R.drawable.ic_password_visibility) else ImageVector.vectorResource(R.drawable.ic_password_invisibility),
                contentDescription = if(isPasswordVisible) stringResource(R.string.password_visibility) else stringResource(R.string.password_invisibility),
                modifier = Modifier

                    .noRippleClickable(
                       onClick = {
                           isPasswordVisible = !isPasswordVisible
                       }
                    )
            )
        }
    )
}

@Preview
@Composable
private fun AtSoptPasswordTextFieldPreview() {
    AtSoptAndroidTheme {
        AtSoptPasswordTextField(
            value = "",
            onValueChange = {}
        )
    }
}
