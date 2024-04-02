package com.example.bookappcompose.feature.book.fav.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookappcompose.feature.book.fav.viewmodel.FavoriteBookViewModel
import com.example.bookappcompose.feature.book.fav.item.FavoriteBookItem
import com.example.domain.books.model.Book


@Composable
fun FavoriteBooksScreen(
    navController: NavController,
    viewModel: FavoriteBookViewModel = hiltViewModel()
) {

    val favItems by viewModel.favoriteBooks.collectAsState()

    FavContent(favResource = favItems)
}

@Composable
fun FavContent(
//    favResource: Resource<List<Book>>
    favResource: List<Book>
) {


//    when (favResource) {
//        is Resource.Loading -> {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator()
//            }
//        }

//        is Resource.Success -> {
            val favBooks = favResource
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            ) {
                items(favBooks) { favBook ->
                    FavoriteBookItem(
                        book = favBook, Modifier
                    )
                }
            }
//        }

//        is Resource.Error -> {
//            Text(text = "Error:")
//        }
//    }
}
