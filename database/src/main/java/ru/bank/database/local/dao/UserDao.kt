package ru.bank.database.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bank.database.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity) : Long

    @Query("SELECT * FROM UserEntity WHERE id = :entityId")
    suspend fun get(entityId: Int): UserEntity

}