package com.greenmarket.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.greenmarket.app.data.model.User

@Dao
interface UserDao: BaseDao<User> {

    @Query("Select * from users")
    suspend fun getAllUsers(): List<User>

    @Query("Select * from users where users.id= :id")
    suspend fun getUserById(id: String): User

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}