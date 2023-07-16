package com.greenmarket.app.data.repositories

import com.greenmarket.app.data.dao.ProductDao
import com.greenmarket.app.data.model.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(private val productDao: ProductDao) :
    BaseRepositoryImpl<Product>(productDao), ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

    override suspend fun getProductById(id: String): Product {
        return productDao.getProductById(id)
    }

    override suspend fun insertProduct(product: Product) {
        productDao.inserProduct(product)
    }

    override suspend fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }
}