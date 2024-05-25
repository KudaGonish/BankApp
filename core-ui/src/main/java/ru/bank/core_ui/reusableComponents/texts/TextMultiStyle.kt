package ru.bank.core_ui.reusableComponents.texts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

@Composable
fun TextMultiStyle(
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    text1: String?,
    text1Style: TextStyle,
    text1Color: Color,
    text2: String?,
    text2Style: TextStyle,
    text2Color: Color,
    appendSymbol: String? = null,
) {
    if (text1 != null || text2 != null) {
        TextOneFloor(
            textAlign= textAlign,
            modifier = modifier,
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = text1Color,
                        fontFamily = text1Style.fontFamily,
                        fontSize = text1Style.fontSize,
                        fontStyle = text1Style.fontStyle,
                        fontFeatureSettings = text1Style.fontFeatureSettings,
                        fontSynthesis = text1Style.fontSynthesis,
                        fontWeight = text1Style.fontWeight,
                        letterSpacing = text1Style.letterSpacing,
                        textDecoration = text1Style.textDecoration
                    )
                ) {
                    append(text1 ?: "")
                    if (!text1.isNullOrBlank() && appendSymbol != null) append(appendSymbol)
                }
                withStyle(
                    style = SpanStyle(
                        color = text2Color,
                        fontFamily = text2Style.fontFamily,
                        fontSize = text2Style.fontSize,
                        fontFeatureSettings = text2Style.fontFeatureSettings,
                        fontSynthesis = text2Style.fontSynthesis,
                        fontWeight = text2Style.fontWeight,
                        textDecoration = text2Style.textDecoration
                    )
                ) {
                    append(text2 ?: "")
                }
            }
        )
    }
}