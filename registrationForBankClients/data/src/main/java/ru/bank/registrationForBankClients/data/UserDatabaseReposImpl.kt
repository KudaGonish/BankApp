package ru.bank.registrationForBankClients.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ru.bank.database.local.dao.UserDao
import ru.bank.registrationForBankClients.domain.model.UserModel
import ru.bank.registrationForBankClients.domain.repository.UserDataBaseRepository
import ru.bank.shareMisc.RepoResponse
import javax.inject.Inject

internal class UserDatabaseReposImpl @Inject constructor(private val userDao: UserDao) :
    UserDataBaseRepository {
    override suspend fun insertUserIntoDatabase(user: UserModel): Flow<RepoResponse<Int>> {

        return flow {
            try {
                val insertedEntityId = userDao.insert(user.toEntity())

                emit(RepoResponse.Succeeded(insertedEntityId.toInt()))

            } catch (ex: Exception) {
                Log.e(className, ex.toString())
                emit(
                    RepoResponse.Failed(
                        "Произошла ошибка при попытке сохранить пользователя" +
                                "\n повторите попытку позже"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    private val className = "UserDataBaseReposImpl"

}