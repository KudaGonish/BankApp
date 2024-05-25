package ru.bank.registrationForBankClients.data

import ru.bank.database.local.entity.UserEntity
import ru.bank.registrationForBankClients.domain.model.UserModel

fun UserModel.toEntity() = UserEntity(
    memberNum = this.memberNum,
    code = this.code,
    name = this.name,
    lastName = this.lastName
)