package ru.bank.settings.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.bank.database.local.dao.UserDao
import ru.bank.settings.domain.model.UserModel
import ru.bank.settings.domain.repository.UserDataBaseRepository
import ru.bank.shareMisc.RepoResponse
import java.lang.IllegalStateException
import javax.inject.Inject

internal class UserDatabaseReposImpl @Inject constructor(private val userDao: UserDao) :
    UserDataBaseRepository {


    override suspend fun getUserInfoById(entityId: Int): Flow<RepoResponse<UserModel>> {
        return flow {

            try {

                val fetchedUser = userDao.get(entityId)?.toModel()
                    ?: throw IllegalStateException("Не удалось получить пользователя с id $entityId")

                emit(RepoResponse.Succeeded(fetchedUser))

            } catch (ex: Exception) {
                Log.e(className, ex.toString())
                emit(
                    RepoResponse.Failed(
                        "Произошла ошибка при попытке получить информацию о пользователе" +
                                "\n повторите попытку позже"
                    )
                )
            }

        }.flowOn(Dispatchers.IO)
    }


    override suspend fun getLastUserInfo(): Flow<RepoResponse<UserModel>> {
        return flow {

            try {

                val fetchedUser = userDao.getLast()?.toModel()
                    ?: throw IllegalStateException("Не удалось получить пользователя")

                emit(RepoResponse.Succeeded(fetchedUser))

            } catch (ex: Exception) {
                Log.e(className, ex.toString())
                emit(
                    RepoResponse.Failed(
                        "Произошла ошибка при попытке получить информацию о пользователе" +
                                "\n повторите попытку позже"
                    )
                )
            }

        }.flowOn(Dispatchers.IO)
    }


    private val className = "UserDataBaseReposImpl"


}