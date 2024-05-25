package ru.bank.registrationForBankClients.presentation.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.bank.core_ui.ScreenState
import ru.bank.registrationForBankClients.domain.InsertUserUseCase
import ru.bank.registrationForBankClients.domain.model.UserModel
import ru.bank.shareMisc.RepoResponse
import javax.inject.Inject

@HiltViewModel
internal class RegistrationForBankClientsViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    private val _messageForUi = MutableSharedFlow<String>()
    val messageForUi = _messageForUi.asSharedFlow()

    private val _screenState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Initial)
    val screenState = _screenState.asStateFlow()


    private val _memberNumTextFieldValue = MutableStateFlow("")
    val memberNumTextFieldValue = _memberNumTextFieldValue.asStateFlow()

    private val _isInErrorMemberNumTextFieldState = MutableStateFlow(false)
    val isInErrorMemberNumTextFieldState = _isInErrorMemberNumTextFieldState.asStateFlow()


    private val _codeFieldValue = MutableStateFlow("")
    val codeFieldValue = _codeFieldValue.asStateFlow()

    private val _isInErrorCodeFieldState = MutableStateFlow(false)
    val isInErrorCodeFieldState = _isInErrorCodeFieldState.asStateFlow()


    private val _nameFieldValue = MutableStateFlow("")
    val nameFieldValue = _nameFieldValue.asStateFlow()

    private val _isInErrorNameFieldState = MutableStateFlow(false)
    val isInErrorNameFieldState = _isInErrorNameFieldState.asStateFlow()


    private val _lastNameFieldValue = MutableStateFlow("")
    val lastNameFieldValue = _lastNameFieldValue.asStateFlow()

    private val _isInErrorLastNameFieldState = MutableStateFlow(false)
    val isInErrorLastNameFieldState = _isInErrorLastNameFieldState.asStateFlow()


    private val _buttonState = MutableStateFlow(true)
    val buttonState = _buttonState.asStateFlow()


    fun setMemberNumTextFieldValue(newValue: String) {
        if (newValue.count() <= 16) {

            _memberNumTextFieldValue.value = newValue.filter { it.isDigit() }

            checkErrorStateMemberNumTextField()

            checkButtonEnabled()

        }

    }

    fun setCodeFieldValue(newValue: String) {

        _codeFieldValue.value = newValue.filter { it.isDigit() }

        checkErrorCodeField()

        checkButtonEnabled()

    }

    fun setNameFieldValue(newValue: String) {

        _nameFieldValue.value = newValue.filter { it.validateLetter() }

        checkErrorStateNameTextField()

        checkButtonEnabled()

    }

    fun setLastNameFieldValue(newValue: String) {

        _lastNameFieldValue.value = newValue.filter { it.validateLetter() }

        checkErrorStateLastNameTextField()

        checkButtonEnabled()

    }

    private fun checkButtonEnabled(): Boolean {
        _buttonState.value = validateMemberNumTextFieldValue() &&
                validateCodeFieldValue() &&
                validateNameFieldValue() &&
                validateLastNameFieldValue()

        return buttonState.value
    }

    private fun checkErrorStateMemberNumTextField() {
        _isInErrorMemberNumTextFieldState.value = !validateMemberNumTextFieldValue()
    }

    private fun checkErrorCodeField() {
        _isInErrorCodeFieldState.value = !validateCodeFieldValue()
    }

    private fun checkErrorStateNameTextField() {
        _isInErrorNameFieldState.value = !validateNameFieldValue()
    }

    private fun checkErrorStateLastNameTextField() {
        _isInErrorLastNameFieldState.value = !validateLastNameFieldValue()
    }

    private fun validateTextFields(): Boolean {
        checkErrorStateMemberNumTextField()
        checkErrorCodeField()
        checkErrorStateNameTextField()
        checkErrorStateLastNameTextField()


        return checkButtonEnabled()
    }

    fun saveBankClientClient(onSuccess: (Int) -> Unit) {

        if (!validateTextFields())
            return

        viewModelScope.launch {

            _screenState.value = ScreenState.Loading

            insertUserUseCase
                .invoke(
                    UserModel(
                        memberNum = memberNumTextFieldValue.value,
                        code = codeFieldValue.value,
                        name = nameFieldValue.value,
                        lastName = lastNameFieldValue.value
                    )
                )
                .catch { _messageForUi.emit("Произошла ошибка...") }
                .onCompletion {
                    _screenState.value = ScreenState.Initial
                }
                .flowOn(Dispatchers.IO)
                .take(1)
                .onEach {

                    when (it) {
                        is RepoResponse.Succeeded -> {
                            onSuccess(it.result)
                        }

                        is RepoResponse.Failed -> {
                            _messageForUi.emit(it.error)
                        }
                    }
                }
                .collect()
        }
    }

    private fun validateMemberNumTextFieldValue() = memberNumTextFieldValue.value.count() == 16
    private fun validateCodeFieldValue() = codeFieldValue.value.isNotBlank()
    private fun validateNameFieldValue() = nameFieldValue.value.isNotBlank()
    private fun validateLastNameFieldValue() = lastNameFieldValue.value.isNotBlank()


    private fun Char.validateLetter() = this.isLetter() || this == '-' || this == ' '
}


