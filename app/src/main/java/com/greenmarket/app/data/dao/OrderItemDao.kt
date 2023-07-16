package com.greenmarket.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.greenmarket.app.data.model.Order

@Dao
interface OrderItemDao: BaseDao<Order> {

    @Query("Select * from orders")
    suspend fun getAllOrders(): List<Order>

    @Query("Select * from orders where orders.id = :orderId")
    suspend fun getOrderById(orderId: String): Order

    @Insert
    suspend fun insertOrder(order: Order)

    @Update
    suspend fun updateOrder(order: Order)
}