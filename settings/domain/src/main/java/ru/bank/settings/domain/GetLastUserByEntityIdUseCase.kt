package ru.bank.settings.domain

import ru.bank.settings.domain.repository.UserDataBaseRepository
import javax.inject.Inject


class GetLastUserUseCase @Inject constructor(private val repos: UserDataBaseRepository) {

    suspend operator fun invoke() = repos.getLastUserInfo()

}