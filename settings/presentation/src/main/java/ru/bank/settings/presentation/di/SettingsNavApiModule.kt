package ru.bank.settings.presentation.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.settings.navigationApi.SettingsNavigationApi
import ru.bank.settings.presentation.navigation.SettingsNavImpl

@Module
@InstallIn(SingletonComponent::class)
private abstract class RegistrationForBankClientsNavApiModule {

    @Binds
    abstract fun bindNavigationApi(
        navigationImpl: SettingsNavImpl
    ): SettingsNavigationApi
}
