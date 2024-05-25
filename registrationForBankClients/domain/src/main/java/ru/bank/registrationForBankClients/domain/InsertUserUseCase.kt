package ru.bank.registrationForBankClients.domain

import ru.bank.registrationForBankClients.domain.model.UserModel
import ru.bank.registrationForBankClients.domain.repository.UserDataBaseRepository
import javax.inject.Inject


class InsertUserUseCase @Inject constructor(private val repos: UserDataBaseRepository) {

    suspend operator fun invoke(user: UserModel) = repos.insertUserIntoDatabase(user)

}