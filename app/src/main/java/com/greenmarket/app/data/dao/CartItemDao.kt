package com.greenmarket.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.greenmarket.app.data.model.CartItem

@Dao
interface CartItemDao: BaseDao<CartItem> {

    @Query("Select * from cart_items")
    suspend fun getAllCartItems(): List<CartItem>

    @Query("Select * from cart_items where cart_items.id= id:")
    suspend fun getCartItemById(id: String): CartItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItem)

    @Update
    suspend fun updateCartItem(cartItem: CartItem)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)

    @Query("Delete from cart_items")
    suspend fun deleteAllCartItems()
}