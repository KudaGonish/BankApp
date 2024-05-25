package ru.bank.core_ui

sealed class ScreenState {
    object Initial: ScreenState()
    object Loading: ScreenState()
}

sealed class ScreenStateAdvanced{

    object Initial: ScreenStateAdvanced()

    object Loading: ScreenStateAdvanced()

    object Success: ScreenStateAdvanced()

    object Empty: ScreenStateAdvanced()

}