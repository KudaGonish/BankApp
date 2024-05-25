package ru.bank.core_ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import ru.bank.core_ui.theme.palette.ButtonPalette
import ru.bank.core_ui.theme.palette.CardMainPalette
import ru.bank.core_ui.theme.palette.SwitchPalette
import ru.bank.core_ui.theme.palette.TextFieldMainPalette
import ru.bank.core_ui.theme.palette.TextPalette

/**
 * Класс-расширение стандартного набора переменных, для хранения цветов,
 * глобально используемых в приложении.
 */
@Immutable
data class ColorsBank(
    val background: Color,
    val button: ButtonPalette,
    val textFiled: TextFieldMainPalette,
    val switch: SwitchPalette,
    val card: CardMainPalette,
    val text: TextPalette
)