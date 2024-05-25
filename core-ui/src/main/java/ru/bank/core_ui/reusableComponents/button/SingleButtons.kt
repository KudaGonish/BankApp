package ru.bank.core_ui.reusableComponents.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.bank.core_ui.reusableComponents.icon.IconRightArrow
import ru.bank.core_ui.reusableComponents.spacers.SpacerHorizontal
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank

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
    buttonHeight: Dp = 50.dp,
    buttonTextStyle: TextStyle = MaterialTheme.typography.button,
    onClick: () -> Unit,
) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colorsBank.button.primaryBackground,
        contentColor = MaterialTheme.colorsBank.button.primaryText,
        disabledBackgroundColor = MaterialTheme.colorsBank.button.disabledBackground,
        disabledContentColor = MaterialTheme.colorsBank.button.primaryText
    )

    Button(
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        modifier = modifier
            .widthIn(min = 130.dp, max = 580.dp)
            .fillMaxWidth()
            .height(buttonHeight),
        enabled = enabled,
        onClick = onClick,
    ) {
        TextOneFloor(
            text = buttonText,
            style = buttonTextStyle,
            color = colors.contentColor(enabled = enabled).value
        )
    }
}

@Composable
fun ButtonBack(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonHeight: Dp = 30.dp,
    buttonTextStyle: TextStyle = MaterialTheme.typography.overline,
    onClick: () -> Unit,
) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colorsBank.button.secondaryBackground,
        contentColor = MaterialTheme.colorsBank.button.secondaryText,
        disabledBackgroundColor = MaterialTheme.colorsBank.button.secondaryBackground,
    )

    Button(
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        modifier = modifier
            .height(buttonHeight),
        enabled = enabled,
        onClick = onClick,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorsBank.button.border
        )
    ) {

        IconRightArrow(modifier = Modifier.rotate(180f))
        SpacerHorizontal(5.dp)
        TextOneFloor(
            text = "Назад",
            style = buttonTextStyle,
            color = colors.contentColor(enabled = enabled).value
        )
    }
}
