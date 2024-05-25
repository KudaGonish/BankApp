package ru.bank.settings.presentation.navigation

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.bank.navigationapi.getArgumentAsIntFromCurrentBackStack
import ru.bank.registrationForBankClients.navigationApi.RegistrationForBankClientsNavigationApi
import ru.bank.settings.navigationApi.SettingsNavigationApi
import ru.bank.settings.presentation.screens.SettingsScreen
import javax.inject.Inject

/*Константы для вложенного графа навигации по экранам модуля настроек.*/

private const val SETTINGS_NAV_GRAPH = "SETTINGS_NAV_GRAPH"
private const val BASE_ROUTE = "settings"

internal class SettingsNavImpl @Inject constructor(
    private val registrationForBankClientsNavigationApi: RegistrationForBankClientsNavigationApi
) : SettingsNavigationApi {

    override val route: String = BASE_ROUTE

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder, navController: NavHostController, modifier: Modifier
    ) {
        navGraphBuilder.composable(route = route) {
            SettingsScreen(
                onNavigateToRegistrationForBankMember = {
                    navController
                        .navigate(
                            registrationForBankClientsNavigationApi.route
                        )
                },
                onReceiveUserId = {
                    navController.getArgumentAsIntFromCurrentBackStack(
                        navArgumentKey =
                        registrationForBankClientsNavigationApi.savedUserIdArgumentKey,
                        debugErrorLog = { msg ->
                            Log.e("$SETTINGS_NAV_GRAPH$::onReceiveResponsible", msg)
                        }
                    )

                }
            )

        }


    }

}