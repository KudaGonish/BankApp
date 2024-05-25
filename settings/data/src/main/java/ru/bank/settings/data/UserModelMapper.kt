package ru.bank.settings.data

import ru.bank.database.local.entity.UserEntity
import ru.bank.settings.domain.model.UserModel

fun UserEntity.toModel() = UserModel(
    memberNum = this.memberNum,
    name = this.name,
    lastName = this.lastName
)