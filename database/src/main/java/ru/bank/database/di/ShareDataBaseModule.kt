package ru.bank.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.bank.database.local.BankDatabase
import ru.bank.database.local.dao.UserDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object ShareDataBaseModule {

    @Singleton
    @Provides
    fun provideUserDao(
        db: BankDatabase
    ): UserDao = db.userDao


    @Singleton
    @Provides
    fun provideBankDataBase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        BankDatabase::class.java,
        "bank_data_base"
    ).build()


}