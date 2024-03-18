package com.example.bookappcompose.feature.cart.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart
import com.example.domain.cart.usecase.AddBookToCart
import com.example.domain.cart.usecase.GetAllBookCartItems
import com.example.domain.cart.usecase.RemoveBookFromCart
import com.example.domain.cart.usecase.UpdateBookInCart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllBooksInCart: GetAllBookCartItems,
    private val addBookToCartUseCase: AddBookToCart,
    private val removeBookFromCartUseCase: RemoveBookFromCart,
    private val updateBookInCart: UpdateBookInCart,


    ) : ViewModel() {
    private val _cartItems = MutableStateFlow<Resource<List<Cart>>>(Resource.Loading)
    val cartItems: StateFlow<Resource<List<Cart>>> = _cartItems

    init {
        loadCartItems()
    }


     fun loadCartItems() {
        _cartItems.value = Resource.Loading
        viewModelScope.launch {
            try {
                val cartBookList = getAllBooksInCart()
                _cartItems.emit(Resource.Success(cartBookList))
                Log.d(TAG,"cartItems${cartBookList}")
            } catch (e: Exception) {
                _cartItems.emit(Resource.Error(e))
            }
        }

    }

//    fun getCartItems (){
//        _cartItems.value = Resource.Loading
//        viewModelScope.launch {
//            try {
//                val cartBookList = getAllBooksInCart()
//                _cartItems.emit(Resource.Success(cartBookList))
//                Log.d(TAG,"cartItems${cartBookList}")
//            } catch (e: Exception) {
//                _cartItems.emit(Resource.Error(e))
//            }
//        }
//    }

    fun addToCart(cart:Cart) {
        viewModelScope.launch {
            try {

                addBookToCartUseCase(cart)
//                loadCartItems()
                Log.d(TAG, "cartItems$cart")
            } catch (e: Exception) {
                _cartItems.emit(Resource.Error(e))
            }
        }
    }


   fun updateItemInCart(cart: Cart) {
        viewModelScope.launch {
            try {
                updateBookInCart(cart)

            } catch (e: Exception) {
                _cartItems.emit(Resource.Error(e))
            }
        }
    }

    fun removeFromCart(cart: Cart) {
        viewModelScope.launch {
            try {
                removeBookFromCartUseCase(cart)
                loadCartItems()
            } catch (e: Exception) {
                _cartItems.emit(Resource.Error(e))
            }
        }
    }





    fun isAddedToCart(book: Book): Boolean {
        val cartI = (cartItems.value as? Resource.Success)?.data ?: emptyList()
        return cartI.any { it.id == book.id }

    }


}