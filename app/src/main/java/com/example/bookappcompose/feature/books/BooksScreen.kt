package com.example.bookappcompose.feature.books

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book


@Composable
fun BooksScreen(
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()

    BooksContent(booksResource = books, onItemClick ={ book ->
                val bookId = book.id
                val bookTitle = book.title
                val bookImage = book.formats.imageJPEG
                val bookDes = book.subjects[0]
                navController.navigate(
                    "book_detail_screen/$bookId/$bookTitle/$bookDes/${
                        Uri.encode(bookImage)}") } )



}

@Composable
fun BooksContent(booksResource: Resource<List<Book>>,
                 onItemClick: (Book) -> Unit) {
    when (booksResource) {
        is Resource.Loading ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        is Resource.Success -> {
            val books = booksResource.data
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            ) {
                items(books) { book ->
                    BookItem(book = book,
                        modifier = Modifier.clickable {
                            onItemClick(book)
                        }
                    )
                }
            }
        }

        is Resource.Error -> Text(text = "Error:") // Show error message
    }
}





