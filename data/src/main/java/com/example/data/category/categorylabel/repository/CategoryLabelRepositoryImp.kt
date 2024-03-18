package com.example.data.category.categorylabel.repository


import com.example.domain.category.categorylabel.model.CategoryLabel
import com.example.domain.category.categorylabel.repository.CategoryLabelRepository


class CategoryLabelRepositoryImp(
) : CategoryLabelRepository {
    override fun getCategoriesLabel(): List<CategoryLabel> {
        return listOf(
            CategoryLabel(1, "Drama","Drama_image"),
            CategoryLabel(2, "Religious","Religious_image"),
            CategoryLabel(3, "History","History_image"),
            CategoryLabel(4, "Children","Children_image"),
            CategoryLabel(5, "Fiction","Fiction_image"),
            CategoryLabel(6, "Medicine","Medicine_image"),
            CategoryLabel(7, "Sports","Sports_image"),
            CategoryLabel(8, "Cooking","Cooking_image"),
            CategoryLabel(9, "Science","Science_image"),
        )
    }


}