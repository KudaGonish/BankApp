package ru.bank.mappedListView.data.dto

import com.google.gson.annotations.SerializedName

data class DataValueDto(
    @SerializedName("data")
    val data: List<DataValueItemDto>
)




