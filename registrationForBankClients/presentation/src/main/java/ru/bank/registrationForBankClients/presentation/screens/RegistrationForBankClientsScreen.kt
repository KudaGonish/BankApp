package ru.bank.registrationForBankClients.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.bank.core_ui.ScreenState
import ru.bank.core_ui.reusableComponents.button.ButtonBack
import ru.bank.core_ui.reusableComponents.button.ButtonConfirm
import ru.bank.core_ui.reusableComponents.scaffold.ColumnDefaultScreen
import ru.bank.core_ui.reusableComponents.scaffold.ScaffoldDefault
import ru.bank.core_ui.reusableComponents.spacers.SpacerFullWeight
import ru.bank.core_ui.reusableComponents.spacers.SpacerVertical
import ru.bank.core_ui.reusableComponents.texts.TextFieldComment
import ru.bank.core_ui.reusableComponents.texts.TextMultiStyle
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder
import ru.bank.registrationForBankClients.presentation.R


@Composable
internal fun RegistrationForBankClientsScreen(
    viewModel: RegistrationForBankClientsViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onContinue: (Int) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    val screenState = viewModel.screenState.collectAsStateWithLifecycle()

    val memberNumTextFieldValue = viewModel.memberNumTextFieldValue.collectAsStateWithLifecycle()
    val isErrorMemberNumTextFieldState =
        viewModel.isInErrorMemberNumTextFieldState.collectAsStateWithLifecycle()

    val codeFieldValue = viewModel.codeFieldValue.collectAsStateWithLifecycle()
    val isErrorCodeFieldState = viewModel.isInErrorCodeFieldState.collectAsStateWithLifecycle()

    val nameFieldValue = viewModel.nameFieldValue.collectAsStateWithLifecycle()
    val isErrorNameFieldState = viewModel.isInErrorNameFieldState.collectAsStateWithLifecycle()

    val lastNameFieldValue = viewModel.lastNameFieldValue.collectAsStateWithLifecycle()
    val isErrorLastNameFieldState =
        viewModel.isInErrorLastNameFieldState.collectAsStateWithLifecycle()

    val buttonState by viewModel.buttonState.collectAsStateWithLifecycle()


    val incorrectData = stringResource(id = R.string.incorrect_data)

    ScaffoldDefault { scaffoldState ->

        LaunchedEffect(Unit) {
            viewModel.messageForUi.collectLatest {
                scaffoldState.snackbarHostState.showSnackbar(it)
            }
        }

        ColumnDefaultScreen {

            ButtonBack(onClick = onBack)

            SpacerVertical(15.dp)

            TextOneFloor(
                text = stringResource(id = R.string.register_for_bank_clients),
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
            )

            SpacerVertical()

            TextFieldWithErrorState(
                focusManager = focusManager,
                keyboardType = KeyboardType.Number,
                isError = isErrorMemberNumTextFieldState,
                value = memberNumTextFieldValue,
                errorText = incorrectData,
                placeholder = stringResource(id = R.string.num_of_participant),
                descText = stringResource(id = R.string.num_of_participant_desc),
                onValueChange = {
                    viewModel.setMemberNumTextFieldValue(it)
                }
            )

            SpacerVertical(15.dp)

            TextFieldWithErrorState(
                focusManager = focusManager,
                keyboardType = KeyboardType.Number,
                isError = isErrorCodeFieldState,
                value = codeFieldValue,
                errorText = incorrectData,
                placeholder = stringResource(id = R.string.code),
                descText = stringResource(id = R.string.code_desc),
                onValueChange = { viewModel.setCodeFieldValue(it) }
            )

            SpacerVertical(15.dp)

            TextFieldWithErrorState(
                focusManager = focusManager,
                keyboardType = KeyboardType.Text,
                isError = isErrorNameFieldState,
                value = nameFieldValue,
                errorText = incorrectData,
                placeholder = stringResource(id = R.string.name),
                descText = stringResource(id = R.string.name_desс),
                onValueChange = {

                    viewModel.setNameFieldValue(it)
                }
            )

            SpacerVertical(15.dp)

            TextFieldWithErrorState(
                focusManager = focusManager,
                keyboardType = KeyboardType.Text,
                isError = isErrorLastNameFieldState,
                value = lastNameFieldValue,
                errorText = incorrectData,
                placeholder = stringResource(id = R.string.last_name),
                descText = stringResource(id = R.string.last_name_desс),
                onValueChange = {
                    viewModel.setLastNameFieldValue(it)
                }
            )

            SpacerFullWeight()

            TextMultiStyle(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                text1 = stringResource(id = R.string.conditions_of_use_1),
                text1Style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Light),
                text1Color = MaterialTheme.colorsBank.text.primary,
                text2 = stringResource(id = R.string.conditions_of_use_2),
                text2Style = MaterialTheme.typography.caption.copy(textDecoration = TextDecoration.Underline),
                text2Color = MaterialTheme.colorsBank.text.primary,
                appendSymbol = " "
            )

            SpacerVertical(10.dp)

            ButtonConfirm(
                buttonText = "Продолжить",
                enabled = buttonState
            ) {
                viewModel.saveBankClientClient(onSuccess = onContinue)
            }
        }

        if (screenState.value is ScreenState.Loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.7f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorsBank.button.primaryBackground,
                    strokeWidth = 3.dp
                )
            }
        }

    }

}

@Composable
fun TextFieldWithErrorState(
    focusManager: FocusManager,
    keyboardType: KeyboardType,
    isError: State<Boolean>,
    value: State<String>,
    placeholder: String,
    errorText: String,
    descText: String,
    onValueChange: (String) -> Unit
) {
    TextFieldComment(
        keyboardType = keyboardType,
        modifier = Modifier
            .fillMaxWidth(),
        textFieldValue = value.value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        componentHeight = 50.dp,
        isError = isError.value,
        errorText = errorText,
        imeAction = ImeAction.Done,
        onKeyboardActionDone = { focusManager.clearFocus() },
    ) { it() }

    SpacerVertical(5.dp)

    TextOneFloor(
        modifier = Modifier.padding(start = 5.dp),
        style = MaterialTheme.typography.caption,
        text = if (isError.value) errorText else descText,
        color = if (isError.value)
            MaterialTheme.colorsBank.text.error
        else
            MaterialTheme.colorsBank.text.description
    )
}


@Preview
@Composable
private fun PreviewScreen() {
    PreviewContainerWithPaddingAndBorder {
        RegistrationForBankClientsScreen(onBack = {}) {}
    }
}
