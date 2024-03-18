package com.example.bookappcompose.feature.category.categorybook.screen

import android.content.ContentValues
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bookappcompose.R
import com.example.bookappcompose.feature.category.categorybook.screen.item.CategoryBookItem
import com.example.bookappcompose.feature.category.categorybook.viewmodel.CategoryBookViewModel
import com.example.bookappcompose.feature.category.categorylabel.screen.item.getImageResId
import com.example.bookappcompose.state.Resource
import com.example.domain.category.categorybooks.model.CategoryBook

@Composable
fun CategoryBookScreen(
    navController: NavController,
    viewModel: CategoryBookViewModel = hiltViewModel(),
    categoryId: Int, categoryName: String, categoryImage: Int
) {
    val categoryBooks by viewModel.catBook.collectAsState()
    LaunchedEffect(categoryName) {
        viewModel.loadBooksAccordingToCategory(categoryName)
    }
    CategoryBookContent(
        categoryBooksResource = categoryBooks,
        onItemClick = { book ->
            val bookId = book.id
            val bookTitle = book.title
            val bookImage = book.formats.imageJPEG
            val bookDes = book.subjects[0]
            navController.navigate(
                "book_detail_screen/$bookId/$bookTitle/$bookDes/${
                    Uri.encode(bookImage)
                }"
            )
        },
        categoryName = categoryName,
        categoryImage = categoryImage
//        loadMore = { viewModel.loadMoreBooks() }
    )


}


@Composable
fun CategoryBookContent(
    categoryBooksResource: Resource<List<CategoryBook>>,
    onItemClick: (CategoryBook) -> Unit,
    categoryName: String,
    categoryImage: Int,
//    loadMore: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = categoryImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = categoryName, fontSize = 20.sp, modifier = Modifier.padding(start = 8.dp)
            )
        }


        val listState = rememberLazyListState()
        when (categoryBooksResource) {
            is Resource.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                val books = categoryBooksResource.data
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                ) {
                    itemsIndexed(books) { index, categoryBook ->
                        CategoryBookItem(
                            categoryBook = categoryBook,
                            modifier = Modifier.clickable {
                                onItemClick(categoryBook)
                            }
                        )
//                    if (index == books.size - 1) {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 32.dp),
//                            contentAlignment = Alignment.BottomCenter
//                        ) {
//                            CircularProgressIndicator()
//                        }
//
//                        loadMore()
//                    }
                    }
                }
            }

            is Resource.Error -> {
                Text(text = "Error:")
            }
        }
    }
}


