package ru.bank.settings.presentation.screens


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.bank.core_ui.ScreenState
import ru.bank.settings.domain.GetLastUserUseCase
import ru.bank.settings.domain.GetUserByEntityIdUseCase
import ru.bank.settings.domain.model.UserModel
import ru.bank.shareMisc.RepoResponse
import javax.inject.Inject

@HiltViewModel
internal class SettingsViewModel @Inject constructor(
    private val getUserByEntityIdUseCase: GetUserByEntityIdUseCase,
    private val getLastUserUseCase: GetLastUserUseCase,
) : ViewModel() {


    private val _messageForUi = MutableSharedFlow<String>()
    val messageForUi = _messageForUi.asSharedFlow()


    private val _switchState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val switchState = _switchState.asStateFlow()


    private val _userInformation = MutableStateFlow(
        UserModel(
            memberNum = "",
            name = "Art",
            lastName = "Art"
        )
    )

    val userInformation = _userInformation.asStateFlow()

    init {

        viewModelScope.launch {

            getLastUserUseCase
                .invoke()
                .catch { _messageForUi.emit("Произошла ошибка...") }
                .flowOn(Dispatchers.IO)
                .take(1)
                .collect {
                    when (it) {
                        is RepoResponse.Succeeded -> {
                            _userInformation.value = it.result
                        }

                        is RepoResponse.Failed -> {
                            _messageForUi.emit(it.error)
                        }
                    }
                }
        }

    }

    fun switchCheckedChange(newState: Boolean) {
        _switchState.value = newState
    }

    fun sendSnackbar(msg: String) {
        viewModelScope.launch {
            _messageForUi.emit(msg)
        }
    }


    fun fetchUserData(entityId: Int) {
        viewModelScope.launch {

            getUserByEntityIdUseCase
                .invoke(entityId)
                .catch { _messageForUi.emit("Произошла ошибка...") }
                .flowOn(Dispatchers.IO)
                .take(1)
                .collect {
                    when (it) {
                        is RepoResponse.Succeeded -> {
                            _userInformation.value = it.result
                        }

                        is RepoResponse.Failed -> {
                            _messageForUi.emit(it.error)
                        }
                    }
                }
        }
    }

}


