package ru.bank.core_ui.reusableComponents.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.bank.core_ui.theme.colorsBank

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


