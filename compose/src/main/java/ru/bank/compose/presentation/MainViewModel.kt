package ru.bank.compose.presentation


import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.bank.registrationForBankClients.navigationApi.RegistrationForBankClientsNavigationApi
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    /* Инжекты для построения графа навигации */


    @Inject
    lateinit var registerForBankClientsNavApi: RegistrationForBankClientsNavigationApi

}