package ru.bank.core_ui.reusableComponents.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.theme.providers.buttonStyles
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder

/**
 * Основная кнопка для подтверждения.
 *
 * @param buttonText текст кнопки.
 * @param buttonHeight высота кнопки.
 * @param buttonType тип кнопки.
 * @param enabled флаг активности кнопки.
 * @param onClick коллбэк, выщываемый при нажатии на кнопку.
 */
@Composable
fun ButtonConfirm(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    buttonHeight: Dp = 56.dp,
    buttonType: ConfirmButtonType = ConfirmButtonType.PRIMARY,
    buttonTextStyle: TextStyle = MaterialTheme.typography.button,
    onClick: () -> Unit,
) {
    val colors = buttonStyles(buttonType = buttonType)

    Button(
        colors = colors,
        modifier = modifier
            .widthIn(min = 130.dp, max = 580.dp)
            .fillMaxWidth()
            .height(buttonHeight)
            .then(
                if (buttonType == ConfirmButtonType.SECONDARY) Modifier.border(
                    border = BorderStroke(
                        1.dp,
                        MaterialTheme.colorsBank.button.border,
                    ),
                ) else Modifier
            ),
        enabled = enabled,
        onClick = onClick,
        border = if (buttonType == ConfirmButtonType.SECONDARY)
            BorderStroke(
                1.dp,
                MaterialTheme.colorsBank.button.border
            ) else null
    ) {
        TextOneFloor(
            text = buttonText,
            style = buttonTextStyle,
            color = colors.contentColor(enabled = enabled).value
        )
    }
}

enum class ConfirmButtonType {
    PRIMARY,
    SECONDARY,
}


@Preview
@Composable
private fun ConfirmButtonPreview() {

    val enabled by remember { mutableStateOf(true) }

    val confirmButtonType = remember {
        mutableStateOf(ConfirmButtonType.PRIMARY)
    }

    PreviewContainerWithPaddingAndBorder() {
        ButtonConfirm(
            modifier = Modifier,
            buttonText = "Кнопка",
            buttonType = confirmButtonType.value,
            enabled = enabled,
            onClick = {
                when (confirmButtonType.value) {
                    ConfirmButtonType.PRIMARY -> confirmButtonType.value =
                        ConfirmButtonType.SECONDARY

                    ConfirmButtonType.SECONDARY -> confirmButtonType.value =
                        ConfirmButtonType.PRIMARY

                }
            }
        )
    }
}
