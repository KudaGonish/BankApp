package ru.bank.core_ui.reusableComponents.spacers

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SpacerHorizontal(width: Dp = 10.dp){
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun SpacerVertical(height: Dp = 20.dp){
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun ColumnScope.SpacerFullWeight(){
    Spacer(modifier = Modifier.weight(1f))
}
@Composable
fun RowScope.SpacerFullWeight(){
    Spacer(modifier = Modifier.weight(1f))
}