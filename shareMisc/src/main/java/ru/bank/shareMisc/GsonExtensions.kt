package ru.bank.shareMisc

import com.google.gson.Gson
import com.google.gson.GsonBuilder

val gson: Gson = GsonBuilder().serializeNulls().create()
fun <T> T.toJson(): String = gson.toJson(this)


inline fun <reified T> String.fromGson(): T =
    gson.fromJson(this, T::class.java)

