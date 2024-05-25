package ru.bank.registrationForBankClients.domain.model

data class UserModel(
    val memberNum: String,
    val code: String,
    val name: String,
    val lastName: String,
)