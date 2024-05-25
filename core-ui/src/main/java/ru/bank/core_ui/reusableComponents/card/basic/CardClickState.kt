package ru.bank.core_ui.reusableComponents.card.basic

import androidx.compose.runtime.Immutable

@Immutable
sealed class CardClickState {
    data class Clickable(val isShowArrow: Boolean, val onClick: () -> Unit) : CardClickState()
    object NotClickable : CardClickState()
}
