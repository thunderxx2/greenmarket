package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.dao.CartItemDao
import com.greenmarket.app.data.model.CartItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartItemRepositoryImpl @Inject constructor(private val cartItemDao: CartItemDao) :
    BaseRepositoryImpl<CartItem>(cartItemDao), CartItemRepository {
    override suspend fun getAllCartItems(): List<CartItem> {
        return cartItemDao.getAllCartItems()
    }

    override suspend fun getCartItemById(id: String): CartItem {
        return cartItemDao.getCartItemById(id)
    }

    override suspend fun insertCartItem(cartItem: CartItem) {
        cartItemDao.insertCartItem(cartItem)
    }

    override suspend fun updateCartItem(cartItem: CartItem) {
        cartItemDao.updateCartItem(cartItem)
    }

    override suspend fun deleteCartItem(cartItem: CartItem) {
        cartItemDao.deleteCartItem(cartItem)
    }

    override suspend fun deleteAllCartItems() {
        cartItemDao.deleteAllCartItems()
    }
}