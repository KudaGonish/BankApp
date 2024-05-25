package ru.bank.core_ui.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.bank.core_ui.theme.BankTheme
import ru.bank.core_ui.theme.colorsBank

@Composable
fun PreviewContainerWithPaddingAndBorder(
    backgroundColor: @Composable  () -> Color = { MaterialTheme.colorsBank.background },
    hasBorder: Boolean = true,
    outerPadding: Dp = 12.dp,
    innerPadding: Dp = 12.dp,
    content: @Composable () -> Unit,
) {

    BankTheme {
        Surface(
            color = backgroundColor()
        ) {
            Box(
                modifier = Modifier
                    .padding(outerPadding)
                    .border(
                        width = 1.dp,
                        color = if (hasBorder) Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(1.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    content()
                }
            }
        }
    }
}