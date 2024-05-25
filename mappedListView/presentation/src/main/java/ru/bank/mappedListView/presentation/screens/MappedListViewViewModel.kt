package ru.bank.mappedListView.presentation.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.bank.mappedListView.domain.GetMapOfValuesUseCase
import ru.bank.shareMisc.RepoResponse
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
internal class MappedListViewViewModel @Inject constructor(
    private val getMapOfValuesUseCase: GetMapOfValuesUseCase,
) : ViewModel() {


    private val _messageForUi = MutableSharedFlow<String>()
    val messageForUi = _messageForUi.asSharedFlow()

    private val _sortedMap = MutableStateFlow<Map<LocalDate, List<String>>>(emptyMap())
    val sortedMap = _sortedMap.asStateFlow()

    init {

        viewModelScope.launch {

            getMapOfValuesUseCase.invoke()
                .catch { _messageForUi.emit("Произошла ошибка...") }
                .flowOn(Dispatchers.IO).take(1)
                .collect {
                    when (it) {
                        is RepoResponse.Succeeded -> {
                            _sortedMap.value = it.result
                        }

                        is RepoResponse.Failed -> {
                            _messageForUi.emit(it.error)
                        }
                    }
                }
        }

    }

}


