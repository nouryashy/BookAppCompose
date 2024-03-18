package com.example.data.cart

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.book.cache.entity.CachedBook

@Database(entities = [CashedCart::class], version = 1,exportSchema = true)
@TypeConverters(CartConverter::class)

abstract class CartDataBase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}