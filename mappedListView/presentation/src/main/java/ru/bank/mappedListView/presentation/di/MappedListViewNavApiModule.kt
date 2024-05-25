package ru.bank.mappedListView.presentation.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bank.mappedListView.navigationApi.MappedListViewNavigationApi
import ru.bank.mappedListView.presentation.navigation.MappedListViewNavImpl

@Module
@InstallIn(SingletonComponent::class)
private abstract class MappedListViewNavApiModule {

    @Binds
    abstract fun bindNavigationApi(
        navigationImpl: MappedListViewNavImpl
    ): MappedListViewNavigationApi
}
