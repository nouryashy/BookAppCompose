package com.example.domain.category.categorylabel.usecase
import com.example.domain.category.categorylabel.repository.CategoryLabelRepository
import javax.inject.Inject

class GetCategoriesLable @Inject constructor(private val categoryRepository: CategoryLabelRepository) {


    suspend operator fun invoke() = categoryRepository.getCategoriesLabel()

}