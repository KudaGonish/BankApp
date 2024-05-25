package ru.bank.compose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.bank.compose.presentation.MainViewModel
import ru.bank.navigationapi.NavigationApi

@ExperimentalComposeUiApi
@Composable
fun MainNavigation(
    viewModel: MainViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = viewModel.settingsNavApi.route) {


        registerGraph(
            navigationApi = viewModel.registerForBankClientsNavApi, navController = navController
        )

        registerGraph(
            navigationApi = viewModel.settingsNavApi, navController = navController
        )


    }


}


fun NavGraphBuilder.registerGraph(
    navigationApi: NavigationApi, navController: NavHostController, modifier: Modifier = Modifier
) {
    navigationApi.registerGraph(
        navGraphBuilder = this, navController = navController, modifier = modifier
    )
}