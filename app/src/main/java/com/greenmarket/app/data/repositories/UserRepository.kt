package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.model.User

interface UserRepository: BaseRepository<User> {
    suspend fun getAllUsers(): List<User>
    suspend fun getUserById(id: String): User
    suspend fun insertUser(user: User)
    suspend fun updateUser(user: User)
}