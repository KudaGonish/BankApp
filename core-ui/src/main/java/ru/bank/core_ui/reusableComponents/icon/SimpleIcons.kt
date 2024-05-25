package ru.bank.core_ui.reusableComponents.icon

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bank.core_ui.R
import androidx.annotation.DrawableRes
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder

/**
 * Базовая иконка.
 *
 * @param modifier модификатор для вложенной реализации [Icon].
 * @param iconTint цвет заливки для иконки.
 */
@Composable
fun IconConfigured(
    @DrawableRes resId: Int,
    modifier: Modifier = Modifier,
    iconTint: Color = MaterialTheme.colorsBank.card.text
) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = null,
        tint = iconTint,
        modifier = modifier
    )
}

/**
 * Иконка в виде стрелочки вправо.
 *
 * @param modifier модификатор для вложенной реализации [IconConfigured].
 * @param iconTint цвет заливки для иконки.
 */
@Composable
fun IconRightArrow(
    modifier: Modifier = Modifier,
    iconTint: Color = MaterialTheme.colorsBank.card.arrow
) {
    //если все будет пллохо, вернуть R.drawable.ic_chevron_right
    IconConfigured(
        resId = R.drawable.ic_default_arrow,
        modifier = modifier,
        iconTint = iconTint
    )
}





@Preview
@Composable
private fun RightArrowPreview() {
    PreviewContainerWithPaddingAndBorder() { IconRightArrow() }
}

