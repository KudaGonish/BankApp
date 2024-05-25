package ru.bank.mappedListView.data.dto

import com.google.gson.annotations.SerializedName

data class DataValueItemDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("name")
    val name: List<String>
)