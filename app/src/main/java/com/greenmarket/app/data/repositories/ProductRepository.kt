package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.model.Product

interface ProductRepository: BaseRepository<Product> {
    suspend fun getAllProducts(): List<Product>
    suspend fun getProductById(id: String): Product
    suspend fun insertProduct(product: Product)
    suspend fun updateProduct(product: Product)
}