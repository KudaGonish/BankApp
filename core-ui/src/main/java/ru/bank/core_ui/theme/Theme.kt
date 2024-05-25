package ru.bank.core_ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.bank.core_ui.theme.providers.bankLightColorPalette


/**
 * Провайдер кастомных цветов приложения для светлой темы, представленных экземпляром [ColorsBank].
 */
private val localBankColors = staticCompositionLocalOf { bankLightColorPalette }


val MaterialTheme.colorsBank: ColorsBank
    @Composable
    @ReadOnlyComposable
    get() = localBankColors.current


/**
 * Главная тема приложения. Оборачивает [MaterialTheme], добавляя
 * дополнительные переменные и функционал.
 */
@Composable
fun BankTheme(
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = colorFF3F3B56,
        darkIcons = false
    )


    // пробрасываем дополнительные переменные внутрь темы
    CompositionLocalProvider(
        localBankColors provides bankLightColorPalette,
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}