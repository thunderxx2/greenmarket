package com.greenmarket.app.di

import android.app.Application
import androidx.room.Room
import com.greenmarket.app.data.dao.ProductDao
import com.greenmarket.app.data.database.AppDatabase
import com.greenmarket.app.data.repositories.ProductRepository
import com.greenmarket.app.data.repositories.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "app_database").build()
    }

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    fun productRepository(productDao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(productDao)
    }
}