package ru.bank.mappedListView.domain

import ru.bank.mappedListView.domain.repository.RemoteRepository
import javax.inject.Inject


class GetMapOfValuesUseCase @Inject constructor(private val repos: RemoteRepository) {

    suspend operator fun invoke() = repos.getMapOfValues()

}