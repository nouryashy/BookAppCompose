package com.example.bookappcompose.feature.books

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.domain.books.usecase.GetAllBooks
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book
import com.example.domain.books.usecase.GetTopBooks

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooks,
    private val getTopBooksUseCase: GetTopBooks
) :
    ViewModel() {
    private var _books = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
    val books: StateFlow<Resource<List<Book>>> = _books


    private var _topBooks = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
    val topBooks: StateFlow<Resource<List<Book>>> = _topBooks

    var currentPage = 1

    init {
        loadAllBooks()
    }

    fun loadAllBooks() {
        _books.value = Resource.Loading
        viewModelScope.launch {
            try {
                val bookList = getAllBooksUseCase(currentPage)
                Log.d(TAG, "loadBooks: $bookList")
//                _books.value = Resource.Success(bookList)
                _books.emit(Resource.Success(bookList))
            } catch (e: Exception) {
//                _books.value = Resource.Error(e)
                _books.emit(Resource.Error(e))
            }
        }
    }


    fun loadTopBooks() {
        _topBooks.value = Resource.Loading
        viewModelScope.launch {
            try {
                val topBooksList = getTopBooksUseCase()
                Log.d(TAG, "loadBooks: $topBooksList")
                _topBooks.emit(Resource.Success(topBooksList.take(10)))
            } catch (e: Exception) {
                _topBooks.emit(Resource.Error(e))
            }
        }
    }


    fun loadNextPage() {
        currentPage++
        loadAllBooks()
    }


}









