package ru.bank.registrationForBankClients.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.registrationForBankClients.data.UserDatabaseReposImpl
import ru.bank.registrationForBankClients.domain.repository.UserDataBaseRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UserDataBaseRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepositoryApi(
        repositoryImpl: UserDatabaseReposImpl
    ): UserDataBaseRepository

}