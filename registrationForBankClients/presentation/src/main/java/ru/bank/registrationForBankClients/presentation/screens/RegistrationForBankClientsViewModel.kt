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

    private val _codeFieldValue = MutableStateFlow("")
    val codeFieldValue = _codeFieldValue.asStateFlow()

    private val _nameFieldValue = MutableStateFlow("")
    val nameFieldValue = _nameFieldValue.asStateFlow()

    private val _lastNameFieldValue = MutableStateFlow("")
    val lastNameFieldValue = _lastNameFieldValue.asStateFlow()

    private val _buttonState = MutableStateFlow(false)
    val buttonState = _buttonState.asStateFlow()


    fun setMemberNumTextFieldValue(newValue: String) {
        if (newValue.count() <= 16) {
            _memberNumTextFieldValue.value = newValue.filter { it.isDigit() }

            checkButtonEnabled()
        }
    }

    fun setCodeFieldValue(newValue: String) {
        _codeFieldValue.value = newValue.filter { it.isDigit() }
        checkButtonEnabled()
    }

    fun setNameFieldValue(newValue: String) {
        _nameFieldValue.value = newValue.filter { it.validateLetter() }
        checkButtonEnabled()
    }

    fun setLastNameFieldValue(newValue: String) {
        _lastNameFieldValue.value = newValue.filter { it.validateLetter() }
        checkButtonEnabled()
    }

    private fun checkButtonEnabled() {
        _buttonState.value = validateMemberNumTextFieldValue() &&
                validateCodeFieldValue() &&
                validateNameFieldValue() &&
                validateLastNameFieldValue()

    }

    fun saveBankClientClient(onSuccess: (Int) -> Unit) {

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


