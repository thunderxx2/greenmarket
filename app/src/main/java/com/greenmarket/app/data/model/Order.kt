package com.greenmarket.app.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey val id: String,
    @Embedded(prefix = "user_") val user: User,
    val totalAmount: Double,
    val orderDate: Long
)
