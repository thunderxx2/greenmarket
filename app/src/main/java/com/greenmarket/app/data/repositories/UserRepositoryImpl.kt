package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.dao.UserDao
import com.greenmarket.app.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) :
    BaseRepositoryImpl<User>(userDao), UserRepository {
    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    override suspend fun getUserById(id: String): User {
        return userDao.getUserById(id)
    }

    override suspend fun insertUser(user: User) {
        return userDao.insertUser(user)
    }

    override suspend fun updateUser(user: User) {
        return userDao.updateUser(user)
    }
}