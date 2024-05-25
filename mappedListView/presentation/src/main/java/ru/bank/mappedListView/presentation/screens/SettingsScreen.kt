package ru.bank.mappedListView.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.bank.core_ui.reusableComponents.button.ButtonBack
import ru.bank.core_ui.reusableComponents.scaffold.ColumnDefaultScreen
import ru.bank.core_ui.reusableComponents.scaffold.ScaffoldDefault
import ru.bank.core_ui.reusableComponents.spacers.SpacerVertical
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
internal fun MappedListViewScreen(
    viewModel: MappedListViewViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {

    val sortedMapByDate = viewModel.sortedMap.collectAsStateWithLifecycle()

    ScaffoldDefault { scaffoldState ->

        LaunchedEffect(Unit) {
            viewModel.messageForUi.collectLatest {
                scaffoldState.snackbarHostState.showSnackbar(it)
            }
        }

        Column(
            modifier = Modifier
                .widthIn(max = 580.dp)
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 20.dp)
        ) {

            ButtonBack(onClick = onBack)

            SpacerVertical(5.dp)

            LazyColumn(modifier = Modifier.fillMaxSize()) {

                sortedMapByDate.value.forEach { (time, values) ->

                    item {

                        TextOneFloor(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = time.toFormattedStringForUI(),
                            style = MaterialTheme.typography.body2
                        )

                        SpacerVertical(10.dp)

                    }

                    items(values) { value ->

                        TextOneFloor(
                            text = value,
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colorsBank.text.description
                        )

                        SpacerVertical(5.dp)
                    }

                }

            }
        }

    }

}


fun LocalDate.toFormattedStringForUI(
    pattern: String = "dd.MM.yyyy", locale: Locale = Locale.getDefault()
): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, locale)
    return formatter.format(this)
}

@Preview
@Composable
private fun PreviewScreen() {
    PreviewContainerWithPaddingAndBorder {
        MappedListViewScreen(onBack = {})
    }
}
