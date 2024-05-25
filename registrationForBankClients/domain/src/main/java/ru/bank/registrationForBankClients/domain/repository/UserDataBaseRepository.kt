package ru.bank.registrationForBankClients.domain.repository

import ru.bank.registrationForBankClients.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import ru.bank.shareMisc.RepoResponse

interface UserDataBaseRepository {

    suspend fun insertUserIntoDatabase(user: UserModel): Flow<RepoResponse<Int>>

}


