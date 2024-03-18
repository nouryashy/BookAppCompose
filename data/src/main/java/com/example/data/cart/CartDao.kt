package com.example.data.cart

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.domain.cart.model.Cart

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    fun getAllCartItems(): List<CashedCart>

    @Query("SELECT * FROM cart_items WHERE id = :bookId")
    suspend fun getCartItemById(bookId: Int): CashedCart

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cart: CashedCart)

    @Update
    suspend fun updateCartItem(cart: CashedCart)

    @Delete
    suspend fun deleteCartItem(cart: CashedCart)

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
}