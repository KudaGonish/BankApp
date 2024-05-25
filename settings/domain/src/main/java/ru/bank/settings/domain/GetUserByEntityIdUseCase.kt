package ru.bank.settings.domain

import ru.bank.settings.domain.repository.UserDataBaseRepository
import javax.inject.Inject


class GetUserByEntityIdUseCase @Inject constructor(private val repos: UserDataBaseRepository) {

    suspend operator fun invoke(entityId: Int) = repos.getUserInfoById(entityId)

}