package com.example.bookappcompose.feature.book.fav.viewmodel


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book
import com.example.domain.books.usecase.GetFavoriteBooks
import com.example.domain.books.usecase.RemoveFromFavorite
import com.example.domain.books.usecase.ToggleFavoriteStatus

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class FavoriteBookViewModel @Inject constructor(

    private val getFavoriteBooksUseCase: GetFavoriteBooks,
    private val toggleFavoriteStatus: ToggleFavoriteStatus,
    private val removeFromFavorite: RemoveFromFavorite

) :ViewModel (){
//
//    private var _favoriteBooks  = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
//    val favoriteBooks: StateFlow<Resource<List<Book>>> = _favoriteBooks



        private var _favoriteBooks  = MutableStateFlow<List<Book>>(emptyList())
    val favoriteBooks: StateFlow<List<Book>> = _favoriteBooks
    init {
        getFavoriteNotes()
    }

    private fun getFavoriteNotes() {

//        _favoriteBooks.value = Resource.Loading
        viewModelScope.launch {
            try {
                val favList = getFavoriteBooksUseCase()
//                _favoriteBooks.emit(Resource.Success(favList))
                _favoriteBooks.emit((favList))
                Log.d(TAG, "Booksfav: ${favList}")
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching favorite books", e)

            }
        }
    }

    fun toggleFavStatus(book: Book) {
        viewModelScope.launch {
            toggleFavoriteStatus(book)
            getFavoriteNotes()
            Log.d(TAG, "Booksaddition: $book")
        }
    }

    fun removeFromBook(book: Book) {
        viewModelScope.launch {
            removeFromFavorite(book)
            Log.d(TAG, "Booksaddition: $book")
        }
    }



}