package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.dao.BaseDao
import javax.inject.Inject

open class BaseRepositoryImpl<T> @Inject constructor(private val baseDao: BaseDao<T>) :
    BaseRepository<T> {
}