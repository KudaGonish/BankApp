package ru.bank.core_ui.theme.providers

import ru.bank.core_ui.theme.ColorsBank
import ru.bank.core_ui.theme.colorFF262239
import ru.bank.core_ui.theme.colorFF3F3B56
import ru.bank.core_ui.theme.colorFF8B89A0
import ru.bank.core_ui.theme.colorFFB5B6CA
import ru.bank.core_ui.theme.colorFFC87084
import ru.bank.core_ui.theme.colorFFFAF9FB
import ru.bank.core_ui.theme.colorFFFF3D58
import ru.bank.core_ui.theme.palette.ButtonPalette
import ru.bank.core_ui.theme.palette.CardMainPalette
import ru.bank.core_ui.theme.palette.SwitchPalette
import ru.bank.core_ui.theme.palette.TextFieldMainPalette
import ru.bank.core_ui.theme.palette.TextPalette

val bankLightColorPalette = ColorsBank(
    background = colorFF3F3B56,
    button = object : ButtonPalette {
        override val primaryBackground = colorFFFF3D58
        override val disabledBackground = colorFFC87084
        override val primaryText = colorFFFAF9FB
        override val secondaryBackground = colorFF3F3B56
        override val secondaryText = colorFFFAF9FB
        override val border = colorFF262239
    },
    switch = object : SwitchPalette {
        override val thumb = colorFFFAF9FB
        override val trackChecked = colorFFFF3D58
        override val trackUnchecked = colorFFC87084
    },
    card = object : CardMainPalette {
        override val background = colorFF262239
        override val arrow = colorFFFAF9FB
        override val text = colorFF8B89A0
    },
    textFiled = object : TextFieldMainPalette {
        override val background = colorFF262239
        override val placeholder = colorFF8B89A0
        override val text = colorFFFAF9FB
    },
    text = object : TextPalette {
        override val primary = colorFFFAF9FB
        override val secondary = colorFF8B89A0
        override val description = colorFFB5B6CA
        override val error = colorFFC87084
    }
)

