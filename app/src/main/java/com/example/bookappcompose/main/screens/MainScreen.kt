package com.example.bookappcompose.main.screens

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookappcompose.feature.books.BookItem
import com.example.bookappcompose.feature.books.BooksContent
import com.example.bookappcompose.feature.books.BooksViewModel
import com.example.bookappcompose.feature.books.MiniBookItem
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel()

) {

    var searchTextState by remember { mutableStateOf("") }
    var searchActiveState by remember { mutableStateOf(false) }
    val topBooks by viewModel.topBooks.collectAsState()

    SearchBar(
        query = searchTextState,
        onQueryChange = { searchTextState = it },
        onSearch = { searchActiveState = false },
        active = true,
        onActiveChange = { searchActiveState = it }, placeholder = {
            Text(text = "Search")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        }, trailingIcon = {
            if (searchActiveState) {
                Icon(modifier = Modifier.clickable {
                    if (searchTextState.isNotEmpty()) {
                        searchTextState = ""
                    } else {
                        searchActiveState = false
                    }

                }, imageVector = Icons.Default.Close, contentDescription = "Close Icon")
            }
        }) {
    }

    when (val resource = topBooks) {
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
            BookContent(
                state = resource.data.filter {
                    it.title.contains(
                        searchTextState,
                        ignoreCase = true
                    )
                },
                onItemClick = {},
            )
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
fun BookContent(
    state: List<Book>,
    onItemClick: (Book) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(), contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        item {
            Text(
                text = "Top Books",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxSize()
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state) { book ->
                    MiniBookItem(book = book,
                        modifier = Modifier.clickable {
                            onItemClick(book)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AuthorsContent(
    state: List<Book>,
    onItemClick: (Book) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(), contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        item {
            Text(
                text = "Top Authors",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}



