package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.dao.OrderItemDao
import com.greenmarket.app.data.model.Order
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderItemRepositoryImpl @Inject constructor(private val orderItemDao: OrderItemDao) :
    BaseRepositoryImpl<Order>(orderItemDao), OrderRepository {
    override suspend fun getAllOrders(): List<Order> {
        return orderItemDao.getAllOrders()
    }

    override suspend fun getOrderById(id: String): Order {
        return orderItemDao.getOrderById(id)
    }

    override suspend fun insertOrder(order: Order) {
        return orderItemDao.insertOrder(order)
    }

    override suspend fun updateOrder(order: Order) {
        return orderItemDao.updateOrder(order)
    }
}