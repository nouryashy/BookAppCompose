package com.example.data.cart.store


import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.data.cart.CartDao
import com.example.data.cart.CashedCart
import com.example.data.cart.mapper.CachedCartMapper
import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CartManager(
//    private val context: Context
    private val cartDao: CartDao,

) {
    suspend fun insertCartItem(cashedCart: CashedCart) {
        cartDao.insertCartItem(cashedCart)
    }

    suspend fun updateCartItem(cashedCart: CashedCart) {
        cartDao.updateCartItem(cashedCart)
    }

    suspend fun deleteCartItem(cashedCart: CashedCart) {
        cartDao.deleteCartItem(cashedCart)
    }

    suspend fun getCartItemById(bookId: Int): CashedCart {

        return cartDao.getCartItemById(bookId)
    }


     fun getAllCartItems(): List<CashedCart> {
        return cartDao.getAllCartItems()
        }


    suspend fun clearCart(){
        cartDao.clearCart()
    }

}

//    private val cartItems = mutableListOf<Cart>()
//    private val sharedPreferences = context.getSharedPreferences("cart_prefs", Context.MODE_PRIVATE)
//
//
//
//    fun addBookToCart(book: Book) {
//        val existingItem = cartItems.find { it.book.id == book.id }
//        if (existingItem != null) {
//            existingItem.quantity++
//        } else {
//            cartItems.add(Cart(book, 1))
//
//        }
//        saveCartItems()
//        Log.d(ContentValues.TAG, "cartItems in repo : ${cartItems}")
//    }
//
//
//    fun getAllBookCartItems(): List<Cart> {
//        Log.d(ContentValues.TAG, "Cart items in list: $cartItems")
//        return cartItems.toList()
//    }
//
//
//    fun removeBookFromCart(bookId: Int, quantity: Int) {
//        val existingItem = cartItems.find { it.book.id == bookId }
//        if (existingItem != null) {
//            if (existingItem.quantity <= quantity) {
//                cartItems.remove(existingItem)
//            } else {
//                existingItem.quantity -= quantity
//            }
//        }
//    }
//
//    private fun saveCartItems() {
//        val gson = Gson()
//        val json = gson.toJson(cartItems)
//        val editor = sharedPreferences.edit()
//        editor.putString("cart_items", json)
//        editor.apply()
//    }
//
//    fun loadCartItemsFromSharedPreferences(): List<Cart> {
//        val json = sharedPreferences.getString("cart_items", null)
//        val gson = Gson()
//        val type = object : TypeToken<List<Cart>>() {}.type
////        cartItems.clear()
//        if (!json.isNullOrEmpty()) {
//            cartItems.addAll(gson.fromJson(json, type))
//        }
//        return cartItems.toList()
//    }


//}