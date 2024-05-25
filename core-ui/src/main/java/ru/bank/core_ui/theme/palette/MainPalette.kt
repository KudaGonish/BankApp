package ru.bank.core_ui.theme.palette

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


/**
 * ```
 * |     Название переменной     |      основная тема     |
 * |-----------------------------|-----------------------|
 * |  primaryBackground          |    [colorFFFF3D58]    |
 * |  disabledBackground         |    [colorFFC87084]    |
 * |  primaryText                |    [colorFFFAF9FB]    |
 * ```
 */
@Immutable
interface ButtonPalette {
    val primaryBackground: Color
    val disabledBackground: Color
    val primaryText: Color


    val secondaryBackground: Color
    val secondaryText: Color
    val border: Color
}


/**
 * ```
 * |     Название переменной     |    основная тема     |
 * |-----------------------------|---------------------|
 * |  thumb                      |   [colorFFFAF9FB]   |
 * |  trackChecked               |   [colorFFFF3D58]   |
 * |  trackUnchecked             |   [colorFFC87084]   |
 * ```
 */
@Immutable
interface SwitchPalette {
    val thumb: Color
    val trackChecked: Color
    val trackUnchecked: Color
}

/**
 * ```
 * |     Название переменной     |    основная тема     |
 * |-----------------------------|---------------------|
 * |  background                 |   [colorFF262239]   |
 * |  arrow                      |   [colorFFFAF9FB]   |
 * |  text3                      |   [colorFF8B89A0]   |
 * ```
 */
@Immutable
interface CardMainPalette {
    val background: Color
    val arrow: Color
    val text: Color
}

/**
 * ```
 * |     Название переменной     |    основная тема     |
 * |-----------------------------|---------------------|
 * |  background                 |   [colorFF262239]   |
 * |  placeholder                |   [colorFF8B89A0]   |
 * |  text3                      |   [colorFFFAF9FB]   |
 * ```
 */
@Immutable
interface TextFieldMainPalette {
    val background: Color
    val placeholder: Color
    val text: Color
}


/**
 * ```
 * |     Название переменной        |    основная тема     |
 * |--------------------------------|---------------------|
 * |  primary                       |   [colorFFFAF9FB]   |
 * |  secondary                     |   [colorFF8B89A0]   |
 * |  description                   |   [colorFFB5B6CA]   |
 * |  error                         |   [colorFFC87084]   |
 * ```
 */
@Immutable
interface TextPalette {
    val primary: Color
    val secondary: Color
    val description: Color
    val error: Color
}