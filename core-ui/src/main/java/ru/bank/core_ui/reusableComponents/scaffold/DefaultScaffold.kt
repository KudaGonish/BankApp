package ru.bank.core_ui.reusableComponents.scaffold

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.bank.core_ui.theme.BankTheme
import ru.bank.core_ui.theme.colorsBank

/**
 * Стандартный scaffold включающий в себя [TopBar], [Snackbar] и FloatingActionButton
 *
 * @param modifier изменяется только при необходимости задать точную высоту/ширину. Пример см. [DrawerMenu]]
 * @param scaffoldBackground задний фон
 * @param topBar верхнее меню приложения, используйте [TopBar] для его определения
 * @param fab floatingActionButton, для определения испальзуйте [FloatingActionButton]
 * @param snackbar Всплывающие уведомления, для выбора типа уведлмдения используйте [SnackbarDefault], [SnackbarWithActionInline], [SnackbarWithActionOnNewLine]
 * @param content Содержимое Scaffold. Для отправки уведомления используйте внутренний [ScaffoldState]
 *
 * @sample DefaultScaffold_day_preview
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ModifierParameter")
@Composable
fun ScaffoldDefaultWithTopBar(
    modifier: Modifier = Modifier.fillMaxSize(),
    scaffoldBackground: Color = MaterialTheme.colorsBank.background,
    content: @Composable BoxScope.(ScaffoldState) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        backgroundColor = scaffoldBackground,
        scaffoldState = scaffoldState,
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            content(scaffoldState)
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DefaultScaffold_preview() {
    BankTheme {
        ScaffoldDefaultWithTopBar() {

        }
    }
}
