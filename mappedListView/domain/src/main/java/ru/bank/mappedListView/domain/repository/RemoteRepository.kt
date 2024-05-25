package ru.bank.mappedListView.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.bank.shareMisc.RepoResponse
import java.time.LocalDate
import java.time.LocalDateTime

interface RemoteRepository {

    suspend fun getMapOfValues(): Flow<RepoResponse<Map<LocalDate, List<String>>>>

}


