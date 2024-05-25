package ru.bank.settings.domain.repository

import ru.bank.settings.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import ru.bank.shareMisc.RepoResponse

interface UserDataBaseRepository {

    suspend fun getUserInfoById(entityId: Int): Flow<RepoResponse<UserModel>>
    suspend fun getLastUserInfo(): Flow<RepoResponse<UserModel?>>

}


