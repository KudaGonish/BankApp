package ru.bank.mappedListView.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.bank.mappedListView.data.dto.DataValueDto
import ru.bank.mappedListView.data.dto.toSortedMapSecondVariant
import ru.bank.mappedListView.domain.repository.RemoteRepository
import ru.bank.shareMisc.RepoResponse
import ru.bank.shareMisc.fromGson
import java.time.LocalDate
import javax.inject.Inject

internal class RemoteRepositoryImpl @Inject constructor() : RemoteRepository {

    override suspend fun getMapOfValues(): Flow<RepoResponse<Map<LocalDate, List<String>>>> {
        return flow {
            try {
                val fetchedData = mockJson.fromGson<DataValueDto>()

                emit(
                    RepoResponse.Succeeded(
                        fetchedData.toSortedMapSecondVariant()
                    )
                )
            } catch (ex: Exception) {
                emit(RepoResponse.Failed("Ошибка получения списка значений"))
                Log.e("RemoteRepositoryImpl", ex.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    private val mockJson = "{\n" +
            "   \"data\": [\n" +
            "      {\n" +
            "         \"date\": \"2022-09-10T21:55:33Z\",\n" +
            "         \"name\": [\n" +
            "            \"123\",\n" +
            "            \"321\"\n" +
            "         ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"date\": \"2022-09-10T21:50:33Z\",\n" +
            "         \"name\": [\n" +
            "            \"1234\",\n" +
            "            \"4321\"\n" +
            "         ]\n" +
            "      },\n" +
            "      \n" +
            "      {\n" +
            "         \"date\": \"2022-09-08T01:55:33Z\",\n" +
            "         \"name\": [\n" +
            "            \"12345\",\n" +
            "            \"54321\"\n" +
            "         ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"date\": \"2022-09-07T21:55:33Z\",\n" +
            "         \"name\": [\n" +
            "            \"123456\",\n" +
            "            \"654321\"\n" +
            "         ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"date\": \"2022-09-07T11:55:33Z\",\n" +
            "         \"name\": [\n" +
            "            \"1234567\",\n" +
            "            \"7654321\"\n" +
            "         ]\n" +
            "      }\n" +
            "   ]\n" +
            "}"

}