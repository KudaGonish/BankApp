package ru.bank.core_ui.reusableComponents.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.bank.core_ui.reusableComponents.containers.ContainerBorderWithErrorTextState
import ru.bank.core_ui.theme.colorsBank

@Composable
fun TextFieldComment(
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType,
    textFieldValue: String?,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle = MaterialTheme.typography.subtitle2,
    componentHeight: Dp = 89.dp,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    isError: Boolean = false,
    errorText: String,
    imeAction: ImeAction = ImeAction.Done,
    onValueChange: (newValue: String) -> Unit,
    onKeyboardActionDone: () -> Unit = { },
    onKeyboardActionNext: () -> Unit = { },
    onKeyboardActionSend: () -> Unit = { },
    decorationBox: @Composable (@Composable () -> Unit) -> Unit = { it() },
) {
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = textFieldValue ?: "",
        onValueChange = onValueChange,
        modifier = modifier
            .height(componentHeight),
        singleLine = singleLine,
        maxLines = if (singleLine) 1 else maxLines,
        textStyle = TextStyle(
            color = if (!isError) MaterialTheme.colorsBank.textFiled.text else MaterialTheme.colorsBank.text.error,
            fontFamily = textStyle.fontFamily,
            fontSize = textStyle.fontSize,
            textAlign = textStyle.textAlign
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            capitalization = KeyboardCapitalization.Sentences,
            autoCorrect = false,
            imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        keyboardActions = KeyboardActions(
            onDone = {
                onKeyboardActionDone()
                focusManager.clearFocus()
            },
            onNext = {
                onKeyboardActionNext()
            },
            onSend = {
                onKeyboardActionSend()
            }
        ),
        decorationBox = { innerTextField ->
            decorationBox {
                ContainerBorderWithErrorTextState(
                    text = errorText,
                    isInErrorState = isError
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorsBank.textFiled.background)
                            .fillMaxWidth()
                            .fillMaxHeight(1f)
                            .padding(horizontal = 11.dp, vertical = 10.dp),
                        contentAlignment = if (singleLine) Alignment.CenterStart else Alignment.TopStart
                    ) {
                        if (textFieldValue.isNullOrBlank()) {
                            TextOneFloor(
                                text = placeholder,
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colorsBank.textFiled.placeholder
                            )
                        }
                        innerTextField()
                    }
                }
            }
        }
    )

}


@Composable
fun TextFieldBasicSingleLine(
    modifier: Modifier,
    textFieldValue: String,
    textStyle: TextStyle = MaterialTheme.typography.body2,
    focusManager: FocusManager,
    componentHeight: Dp = 39.dp,
    onValueChange: (newValue: String) -> Unit,
    textFieldContentAlignment: Alignment = Alignment.CenterStart,
    innerTextFieldWrapper: @Composable (innerTextField: @Composable () -> Unit) -> Unit,
) {

    BasicTextField(
        value = textFieldValue,
        onValueChange = onValueChange,
        modifier = modifier
            .height(componentHeight)
            .focusable(),
        singleLine = true,
        textStyle = TextStyle(
            color = MaterialTheme.colorsBank.text.secondary,
            fontFamily = textStyle.fontFamily,
            fontSize = textStyle.fontSize,
            textAlign = textStyle.textAlign
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        ),
        decorationBox = { innerTextField ->

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorsBank.textFiled.background)
                    .padding(horizontal = 5.dp)
                    .fillMaxSize(),
                contentAlignment = textFieldContentAlignment
            ) {
                innerTextFieldWrapper(innerTextField)
            }

        }
    )
}


