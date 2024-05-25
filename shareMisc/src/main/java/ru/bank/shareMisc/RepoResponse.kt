package ru.bank.shareMisc

sealed class RepoResponse<out Result> {

    data class Succeeded<out Result>(val result: Result) : RepoResponse<Result>()

    data class Failed(val error: String) : RepoResponse<Nothing>()
}