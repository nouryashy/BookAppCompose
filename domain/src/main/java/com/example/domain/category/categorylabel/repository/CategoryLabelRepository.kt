package com.example.domain.category.categorylabel.repository

import com.example.domain.category.categorylabel.model.CategoryLabel

interface CategoryLabelRepository {
    fun getCategoriesLabel(): List<CategoryLabel>

}