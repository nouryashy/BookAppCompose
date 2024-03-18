package com.example.bookappcompose.di


import android.app.Application
import android.content.Context
import com.example.data.book.cache.mapper.CachedBookMapper
import com.example.data.cart.CartDao
import com.example.data.cart.mapper.CachedCartMapper
import com.example.data.cart.repository.CartRepositoryImp
import com.example.data.cart.store.CartManager
import com.example.domain.cart.repository.CartRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CartRepositoryModule {

//    @Provides
//    fun provideContext(application: Application): Context {
//        return application.applicationContext
//    }
//    @Provides
//    fun provideCartManager(context: Context): CartManager {
//        return CartManager(context)
//    }

    @Provides
    fun provideCachedCartMapper(): CachedCartMapper {
        return CachedCartMapper
    }

    @Provides
    fun provideCartManager(cartDao: CartDao): CartManager {
        return CartManager(cartDao)
    }

    @Provides
    fun provideCartRepository(cartManager: CartManager, mapper: CachedCartMapper)
            : CartRepository {
        return CartRepositoryImp(cartManager, mapper)
    }
}