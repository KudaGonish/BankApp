package ru.bank.registrationForBankClients.presentation.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.registrationForBankClients.navigationApi.RegistrationForBankClientsNavigationApi
import ru.bank.registrationForBankClients.presentation.navigation.RegistrationForBankClientsNavImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RegistrationForBankClientsNavApiModule {

    @Binds
    abstract fun bindNavigationApi(
        navigationImpl: RegistrationForBankClientsNavImpl
    ): RegistrationForBankClientsNavigationApi
}
