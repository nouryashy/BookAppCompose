package com.example.domain.category.categorybooks.usecase

import com.example.domain.category.categorybooks.repository.CategoryBooksRepository
import javax.inject.Inject

class GetBooksAccordingToCategories
@Inject constructor(private val categoryBookRepository: CategoryBooksRepository) {
    suspend operator fun invoke(topic: String) =
        categoryBookRepository.getBooksAccordingToCategories(topic)
}