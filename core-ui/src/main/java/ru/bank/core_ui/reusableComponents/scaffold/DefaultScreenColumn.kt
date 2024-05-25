package ru.bank.core_ui.reusableComponents.scaffold

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * Column для стандартных экранов.
 */
@Composable
fun ColumnDefaultScreen(
    modifier: Modifier = Modifier,
    scrollEnabled:Boolean = true,
    topPadding: Dp = 20.dp,
    content: @Composable ColumnScope.(scrollState: ScrollState) -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .widthIn(max = 580.dp)
            .fillMaxSize()
            .verticalScroll(enabled = scrollEnabled,state = scrollState)
            .padding(start = 12.dp, end = 12.dp, top = topPadding, bottom = 20.dp)
    ) {
        content(scrollState)
    }
}