package com.example.bookappcompose

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bookappcompose.feature.books.BooksViewModel
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book

@Composable
fun BooksScreen(navController: NavController, viewModel: BooksViewModel) {
    val booksList by viewModel.books.collectAsState()

    when (val resource = booksList) {
        is Resource.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            LazyColumn {

                items(resource.data) { books ->
                    BookItem(book = books) {
                        navController.navigate("book_detail/${books.id}")

                    }
                }

            }
        }

        is Resource.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error", color = Color.Red)
            }
        }
    }
}


@Composable
fun BookItem(book: Book, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { onItemClick.invoke() }, shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = book.formats.imageJPEG),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = book.title, Modifier.size(16.dp))
                for (i in book.subjects) {
                    Text(
                        text = i, Modifier.size(
                            12.dp
                        )
                    )
                }
            }
        }




}
}
