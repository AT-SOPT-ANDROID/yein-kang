package org.sopt.at.presentation.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.R
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun AtSoptTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    trailingIcon: @Composable (() -> Unit)? = null
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue(value)) }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusManager = LocalFocusManager.current

    BackHandler {
        focusManager.clearFocus()
    }

    BasicTextField(
        value = value,
        onValueChange = {
            textFieldState = textFieldState.copy(text = it)
            onValueChange(it)
        },
        singleLine = maxLines == 1,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        textStyle = TextStyle(
            color = AtSoptTheme.colors.textPrimary
        ),
        cursorBrush = SolidColor(AtSoptTheme.colors.textPrimary),
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (isFocused) AtSoptTheme.colors.backgroundSecondary else AtSoptTheme.colors.backgroundTertiary)
            .border(
                width = 1.dp,
                color = if (isFocused) AtSoptTheme.colors.dividerPrimary else Color.Transparent
            )
            .padding(16.dp),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    if(value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = AtSoptTheme.colors.textSecondary
                        )
                    }
                    innerTextField()
                }

                if(trailingIcon != null) {
                    trailingIcon()
                }
            }
        }
    )
}

@Preview
@Composable
fun AtSoptTextFieldPreview() {
    AtSoptAndroidTheme {
        AtSoptTextField(
            value = "",
            onValueChange = {},
            placeholder = stringResource(R.string.id),
        )
    }
}
