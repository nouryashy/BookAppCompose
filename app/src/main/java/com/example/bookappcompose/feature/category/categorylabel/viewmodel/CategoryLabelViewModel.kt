package com.example.bookappcompose.feature.category.categorylabel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookappcompose.state.Resource
import com.example.domain.category.categorylabel.model.CategoryLabel
import com.example.domain.category.categorylabel.usecase.GetCategoriesLable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryLabelViewModel @Inject constructor(
    private val getCategoryLabelUseCase: GetCategoriesLable
) : ViewModel() {
//    fun getCategoriesLabel() = getCategoryLabelUseCase.execute()

private var _catBooksLabel = MutableStateFlow<Resource<List<CategoryLabel>>>(Resource.Loading)
    val catBookLabels: StateFlow<Resource<List<CategoryLabel>>> = _catBooksLabel

    init {
        loadBooksCategories()
    }
    fun loadBooksCategories() {
        _catBooksLabel.value = Resource.Loading
        viewModelScope.launch {
            try {
                val categoryBookList = getCategoryLabelUseCase()
                _catBooksLabel.value = Resource.Success(categoryBookList)
            } catch (e: Exception) {
                _catBooksLabel.value = Resource.Error(e)
            }
        }
    }

}