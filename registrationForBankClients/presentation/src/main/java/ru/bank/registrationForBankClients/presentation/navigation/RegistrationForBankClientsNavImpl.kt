package ru.bank.registrationForBankClients.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.bank.navigationapi.setPreviousBackStackEntry
import ru.bank.registrationForBankClients.navigationApi.RegistrationForBankClientsNavigationApi
import ru.bank.registrationForBankClients.presentation.screens.RegistrationForBankClientsScreen
import javax.inject.Inject

/*Константы для вложенного графа навигации по экранам модуля настроек.*/

private const val REGISTRATION_NAV_GRAPH = "REGISTRATION_NAV_GRAPH"
private const val BASE_ROUTE = "registration"

internal class RegistrationForBankClientsNavImpl @Inject constructor() :
    RegistrationForBankClientsNavigationApi {
    override val savedUserIdArgumentKey = "SavedUserIdArgumentKey"

    override val route: String = BASE_ROUTE

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder, navController: NavHostController, modifier: Modifier
    ) {
        navGraphBuilder.composable(route = route) {
            RegistrationForBankClientsScreen(
                onBack = {
                    navController.popBackStack()
                },
                onContinue = {
                    navController.setPreviousBackStackEntry(
                        savedUserIdArgumentKey, it
                    )
                    navController.popBackStack()
                }
            )

        }


    }

}