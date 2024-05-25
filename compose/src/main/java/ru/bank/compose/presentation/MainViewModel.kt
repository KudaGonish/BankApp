package ru.bank.compose.presentation


import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.bank.mappedListView.navigationApi.MappedListViewNavigationApi
import ru.bank.registrationForBankClients.navigationApi.RegistrationForBankClientsNavigationApi
import ru.bank.settings.navigationApi.SettingsNavigationApi
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    /* Инжекты для построения графа навигации */
    @Inject
    lateinit var registerForBankClientsNavApi: RegistrationForBankClientsNavigationApi


    @Inject
    lateinit var settingsNavApi: SettingsNavigationApi
    @Inject
    lateinit var mappedListViewNavApi: MappedListViewNavigationApi

}