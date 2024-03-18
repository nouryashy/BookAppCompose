package com.example.bookappcompose.feature.author.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.authors.model.Authors
import com.example.domain.authors.usecase.GetAuthors

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private val getAuthorsUseCase: GetAuthors
) :
    ViewModel() {
    private var _authors = MutableStateFlow<Resource<List<Authors>>>(Resource.Loading)
    val authors: StateFlow<Resource<List<Authors>>> = _authors
    init {
        getAuthors()
    }

    fun getAuthors() {
        viewModelScope.launch {
            try {
                val authorList = getAuthorsUseCase()
                _authors.value = Resource.Success(authorList)
            } catch (e: Exception) {
                _authors.value = Resource.Error(e)
            }
        }
    }


    fun getTopAuthors() {
        viewModelScope.launch {
            try {
                val authorList = getAuthorsUseCase()
                _authors.value = Resource.Success(authorList.take(10))
            } catch (e: Exception) {
                _authors.value = Resource.Error(e)
            }
        }
    }

}