package ru.bank.mappedListView.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.bank.mappedListView.navigationApi.MappedListViewNavigationApi
import ru.bank.mappedListView.presentation.screens.MappedListViewScreen
import javax.inject.Inject

/*Константы для вложенного графа навигации по экранам модуля настроек.*/

private const val SETTINGS_NAV_GRAPH = "MAPPED_LIST_VIEW_NAV_GRAPH"
private const val BASE_ROUTE = "mappedListView"

internal class MappedListViewNavImpl @Inject constructor() : MappedListViewNavigationApi {

    override val route: String = BASE_ROUTE

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder, navController: NavHostController, modifier: Modifier
    ) {
        navGraphBuilder.composable(route = route) {
            MappedListViewScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }

}