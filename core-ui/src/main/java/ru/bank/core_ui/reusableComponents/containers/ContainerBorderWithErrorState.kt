package ru.bank.core_ui.reusableComponents.containers

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bank.core_ui.R
import ru.bank.core_ui.reusableComponents.spacers.SpacerVertical
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank


@Composable
fun ContainerBorderWithErrorTextState(
    isInErrorState: Boolean = false,
    borderShape: Shape = RoundedCornerShape(size = 16.dp),
    borderWidth: Dp = 1.dp,
    text: String,
    textDefaultColor: Color = MaterialTheme.colorsBank.text.secondary,
    errorColor: Color = MaterialTheme.colorsBank.text.error,
    content: @Composable () -> Unit,
) {
    Column {
        Box(
            modifier = Modifier
                .then(
                    if (isInErrorState) Modifier.border(
                        width = borderWidth,
                        color = errorColor,
                        shape = borderShape
                    ) else Modifier
                )
                .clip(borderShape),
            contentAlignment = Alignment.Center
        ) { content() }

        SpacerVertical(6.dp)

        if (text.isNotBlank()) {
            TextOneFloor(
                text = text,
                color = if (isInErrorState) errorColor else textDefaultColor,
            )
        }
    }


}

