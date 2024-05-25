package ru.bank.database.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("member_number")
    val memberNum: String,
    @ColumnInfo("code")
    val code: String,
    @ColumnInfo("first_name")
    val name: String,
    @ColumnInfo("last_name")
    val lastName: String,
)