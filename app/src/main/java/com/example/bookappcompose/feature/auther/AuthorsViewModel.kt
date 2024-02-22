package com.example.bookappcompose.feature.auther

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.authors.model.Authors
import com.example.domain.authors.usecase.GetAuthors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

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

}