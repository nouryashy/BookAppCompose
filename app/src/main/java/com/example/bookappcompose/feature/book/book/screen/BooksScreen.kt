package com.example.bookappcompose.feature.book.book.screen

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.bookappcompose.feature.book.book.viewmodel.BooksViewModel
import com.example.bookappcompose.feature.book.book.screen.items.BookItem
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book


@Composable
fun BooksScreen(
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()

    BooksContent(booksResource = books, onItemClick = { book ->
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

        loadMore = { viewModel.loadMoreBooks() }
    )
}


@Composable
fun BooksContent(
    booksResource: Resource<List<Book>>,
    onItemClick: (Book) -> Unit,
    loadMore: () -> Unit,
) {
    val listState = rememberLazyListState()

    when (booksResource) {
        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            val books = booksResource.data
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            ) {
                itemsIndexed(books) { index, book ->
                    BookItem(
                        book = book,
                        modifier = Modifier.clickable {
                            onItemClick(book)
                        }
                    )
                    if (index == books.size - 1) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            CircularProgressIndicator()
                        }

                        loadMore()
                    }
                }
            }
        }
//
        is Resource.Error -> {
            Text(text = "Error:")
        }
    }
}

