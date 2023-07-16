package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.model.CartItem

interface CartItemRepository: BaseRepository<CartItem> {
    suspend fun getAllCartItems(): List<CartItem>
    suspend fun getCartItemById(id: String): CartItem
    suspend fun insertCartItem(cartItem: CartItem)
    suspend fun updateCartItem(cartItem: CartItem)
    suspend fun deleteCartItem(cartItem: CartItem)
    suspend fun deleteAllCartItems()
}