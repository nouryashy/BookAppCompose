package com.example.bookappcompose.feature.category.categorylabel.screen

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookappcompose.R
import com.example.bookappcompose.feature.category.categorylabel.screen.item.CategoryLabelItem
import com.example.bookappcompose.feature.category.categorylabel.screen.item.getImageResId
import com.example.bookappcompose.feature.category.categorylabel.viewmodel.CategoryLabelViewModel
import com.example.bookappcompose.state.Resource
import com.example.domain.category.categorylabel.model.CategoryLabel

@Composable
fun CategoryLabelScreen(
    navController: NavController,
    viewModel: CategoryLabelViewModel = hiltViewModel()
) {
    val categoriesLabels by viewModel.catBookLabels.collectAsState()
    CategoryLabelContent(categoriesLabelResource = categoriesLabels, onItemClick = { categoryLabel ->
        val categoryId = categoryLabel.id
        val categoryName = categoryLabel.name
        val categoryImage =  when (categoryLabel.imageResourceName) {
            "Drama_image" -> R.drawable.ic_drama
            "Religious_image" -> R.drawable.ic_religious
            "History_image" -> R.drawable.ic_history
            "Children_image" -> R.drawable.ic_children
            "Fiction_image" -> R.drawable.ic_fiction
            "Medicine_image" -> R.drawable.ic_medical
            "Sports_image" -> R.drawable.ic_sports
            "Cooking_image" -> R.drawable.ic_cooking
            "Science_image" -> R.drawable.ic_science
            else -> R.drawable.ic_drama
        }

        navController.navigate("category_book_screen/$categoryId/$categoryName/$categoryImage")

    })
}

@Composable
fun CategoryLabelContent(
    categoriesLabelResource: Resource<List<CategoryLabel>>,
    onItemClick: (CategoryLabel) -> Unit
) {

    when (categoriesLabelResource) {
        is Resource.Loading ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

        is Resource.Success -> {
            val categoryLabels = categoriesLabelResource.data

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(categoryLabels) { categoryLabel ->
                    CategoryLabelItem(categoryLabel = categoryLabel,
                        modifier = Modifier.clickable {
                            onItemClick(categoryLabel)
                        })
                }
            }

        }

        is Resource.Error -> Text(text = "Error:") // Show error message
    }
}
