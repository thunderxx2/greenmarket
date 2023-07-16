package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.model.Order

interface OrderRepository: BaseRepository<Order> {
    suspend fun getAllOrders(): List<Order>
    suspend fun getOrderById(id: String): Order
    suspend fun insertOrder(order: Order)
    suspend fun updateOrder(order: Order)
}