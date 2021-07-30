package com.yubin.memo60.db_user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User (
    val id : String,
    val pw : String,
    val name : String
        ){
    @PrimaryKey(autoGenerate = true) var idx: Int = 0
}