package ru.bank.mappedListView.data.dto

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun DataValueDto.toSortedMap(): Map<LocalDate, List<String>> {

    val mutableMap = mutableMapOf<LocalDate, MutableList<String>>()

    this@toSortedMap.data.forEach { dataValueItem ->

        val parsedDate = LocalDate.parse(
            dataValueItem.date,
            DateTimeFormatter.ofPattern("yyyy-mm-ddThh:MM:ssZ")
        )

        mutableMap[parsedDate].let {

            val namesAsMutableList = dataValueItem.name.toMutableList()

            if (it == null) {
                mutableMap.put(parsedDate, namesAsMutableList)
            } else {
                mutableMap[parsedDate]!!.addAll(namesAsMutableList)
            }

        }

    }

    return mutableMap
}

fun DataValueDto.toSortedMapSecondVariant() = buildMap<LocalDate, List<String>> {

    this@toSortedMapSecondVariant.data.forEach { dataValueItem ->

        val parsedDate = LocalDate.parse(
            dataValueItem.date,
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        )

        this[parsedDate].let {

            if (it == null) {

                this.put(parsedDate, dataValueItem.name)

            } else {

                this.put(parsedDate, it + dataValueItem.name)

            }

        }

    }

}