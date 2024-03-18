package com.example.bookappcompose.feature.category.categorybook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.category.categorybooks.model.CategoryBook
import com.example.domain.category.categorybooks.usecase.GetBooksAccordingToCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryBookViewModel @Inject constructor(
    private val getCategoryBooksUseCase: GetBooksAccordingToCategories
) : ViewModel() {
    private var _catBooks = MutableStateFlow<Resource<List<CategoryBook>>>(Resource.Loading)
    val catBook: StateFlow<Resource<List<CategoryBook>>> = _catBooks



    fun loadBooksAccordingToCategory(topic: String) {
        _catBooks.value = Resource.Loading
        viewModelScope.launch {
            try {
                val categoryBookList = getCategoryBooksUseCase(topic)
                _catBooks.emit(Resource.Success(categoryBookList))
            } catch (e: Exception) {
                _catBooks.emit(Resource.Error(e))
            }
        }
    }
}
