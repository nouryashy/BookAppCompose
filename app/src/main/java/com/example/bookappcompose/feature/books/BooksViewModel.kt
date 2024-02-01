package com.example.bookappcompose.feature.books

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.domain.books.usecase.GetBooks
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCase: GetBooks
) :
    ViewModel() {
    private var _books = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
    val books: StateFlow<Resource<List<Book>>> = _books
    var currentPage = 1


    fun loadBooks() {
        _books.value = Resource.Loading
        viewModelScope.launch {
            try {
                val bookList = getBooksUseCase(currentPage)
                Log.d(TAG, "loadBooks: $bookList")
//                _books.value = Resource.Success(bookList)
                _books.emit(Resource.Success(bookList))
            } catch (e: Exception) {
//                _books.value = Resource.Error(e)
                _books.emit(Resource.Error(e))
            }
        }
    }

    fun loadNextPage() {
        currentPage++
        loadBooks()
    }


}









