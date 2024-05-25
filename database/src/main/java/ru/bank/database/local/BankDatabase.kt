package ru.bank.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.bank.database.local.dao.UserDao
import ru.bank.database.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 1,

    )
internal abstract class BankDatabase : RoomDatabase() {

    abstract val userDao: UserDao

}