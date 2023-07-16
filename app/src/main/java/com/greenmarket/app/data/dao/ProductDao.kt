package com.greenmarket.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.greenmarket.app.data.model.Product

@Dao
interface ProductDao: BaseDao<Product> {
    @Query("Select * from products")
    fun getAllProducts(): List<Product>

    @Query("Select * from products where products.id= :productId")
    fun getProductById(productId: String): Product

    @Insert
    fun inserProduct(product: Product)

    @Update
    fun updateProduct(product: Product)
}