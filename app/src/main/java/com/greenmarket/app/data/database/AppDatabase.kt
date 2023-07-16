package com.greenmarket.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greenmarket.app.data.dao.ProductDao
import com.greenmarket.app.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_data"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}