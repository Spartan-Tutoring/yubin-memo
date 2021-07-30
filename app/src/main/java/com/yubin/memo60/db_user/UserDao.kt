package com.yubin.memo60.db_user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM UserTable")
    fun getUsers(): List<User>

    @Query("SELECT idx, id, pw, name FROM UserTable WHERE id = :id AND pw = :pw")
    fun getUser(id: String, pw: String): User?

    @Insert
    fun insertUser(user: User)

    @Query("DELETE FROM UserTable")
    fun deleteUsers()

    @Query("SELECT idx, id, pw, name FROM UserTable WHERE id = :id")
    fun getUserById(id: String): User?

    @Query("SELECT idx, id, pw, name FROM UserTable WHERE idx = :idx")
    fun getUserByIdx(idx: Int): User?
}