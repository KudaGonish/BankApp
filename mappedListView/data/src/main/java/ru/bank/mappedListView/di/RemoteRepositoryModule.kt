package ru.bank.mappedListView.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.mappedListView.data.RemoteRepositoryImpl
import ru.bank.mappedListView.domain.repository.RemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepositoryApi(
        repositoryImpl: RemoteRepositoryImpl
    ): RemoteRepository

}