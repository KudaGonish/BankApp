package ru.bank.navigationapi


import androidx.navigation.NavHostController

inline fun <reified T> NavHostController.getJsonArgumentFromPreviousBackStack(
    convertFromJson: String.() -> T,
    navArgumentKey: String,
    debugErrorLog: (exceptionMsg: String) -> Unit = { }
): T? {
    return previousBackStackEntry?.savedStateHandle?.run {

        try { get<String>(navArgumentKey)?.convertFromJson() }

        catch (ex: Exception) {
            if (BuildConfig.DEBUG) debugErrorLog(ex.toString())
            null
        }

        finally { remove<String>(navArgumentKey) }
    }
}

fun NavHostController.getArgumentAsIntFromPreviousBackStack(
    navArgumentKey: String,
    debugErrorLog: (exceptionMsg: String) -> Unit = { }
): Int? {

    return previousBackStackEntry?.savedStateHandle?.run {

        try {
            get<Int>(navArgumentKey)
        }
        catch (ex: Exception) {
            if (BuildConfig.DEBUG) debugErrorLog(ex.toString())
            null
        }

        finally { remove<String>(navArgumentKey) }
    }
}
fun NavHostController.getArgumentAsIntFromCurrentBackStack(
    navArgumentKey: String,
    debugErrorLog: (exceptionMsg: String) -> Unit = { }
): Int? {

    return currentBackStackEntry?.savedStateHandle?.run {

        try {
            get<Int>(navArgumentKey)
        }
        catch (ex: Exception) {
            if (BuildConfig.DEBUG) debugErrorLog(ex.toString())
            null
        }

        finally { remove<String>(navArgumentKey) }
    }
}

fun <T>NavHostController.setCurrentBackStackEntry(
    navArgumentKey: String,
    value: T
){
    this.currentBackStackEntry?.savedStateHandle?.set(
        navArgumentKey,
        value
    )
}

fun <T>NavHostController.setPreviousBackStackEntry(
    navArgumentKey: String,
    value: T
){
    this.previousBackStackEntry?.savedStateHandle?.set(
        navArgumentKey,
        value
    )
}