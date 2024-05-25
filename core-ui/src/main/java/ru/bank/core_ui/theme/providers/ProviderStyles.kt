package ru.bank.core_ui.theme.providers

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ru.bank.core_ui.reusableComponents.button.ConfirmButtonType
import ru.bank.core_ui.theme.colorsBank

@Composable
internal fun buttonStyles(
    buttonType: ConfirmButtonType = ConfirmButtonType.PRIMARY
) = when (buttonType) {
    ConfirmButtonType.PRIMARY -> {
        ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorsBank.button.primaryBackground,
            contentColor = MaterialTheme.colorsBank.button.primaryText,
            disabledBackgroundColor =MaterialTheme.colorsBank.button.disabledBackground,
            disabledContentColor = MaterialTheme.colorsBank.button.primaryText
        )
    }
    ConfirmButtonType.SECONDARY -> {
        ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorsBank.button.secondaryBackground,
            contentColor = MaterialTheme.colorsBank.button.secondaryText,
            disabledBackgroundColor =MaterialTheme.colorsBank.button.secondaryBackground,
        )
    }
}
