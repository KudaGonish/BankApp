package ru.bank.settings.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.settings.data.UserDatabaseReposImpl
import ru.bank.settings.domain.repository.UserDataBaseRepository
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