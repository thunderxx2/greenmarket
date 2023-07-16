package com.greenmarket.app.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @Embedded(prefix = "product_") val product: Product,
    val quantity: Int
)