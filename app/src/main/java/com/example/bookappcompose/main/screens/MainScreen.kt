package com.example.bookappcompose.main.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookappcompose.feature.author.item.AuthorItem
import com.example.bookappcompose.feature.author.viewmodel.AuthorsViewModel
import com.example.bookappcompose.feature.book.viewmodel.BooksViewModel
import com.example.bookappcompose.feature.book.screen.items.MiniBookItem
import com.example.bookappcompose.feature.cart.viewmodel.CartViewModel
import com.example.bookappcompose.main.composoble.SearchBarView
import com.example.bookappcompose.state.Resource
import com.example.domain.authors.model.Authors
import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    booksViewModel: BooksViewModel = hiltViewModel(),
    authorsViewModel: AuthorsViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel()
) {
    var searchTextState by remember { mutableStateOf("") }
    var searchActiveState by remember { mutableStateOf(false) }

    val topBooks by booksViewModel.topBooks.collectAsState()
    val topAuthors by authorsViewModel.authors.collectAsState()

    val cartI by cartViewModel.cartItems.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        SearchBarView(
            searchText = searchTextState,
            searchActive = searchActiveState,
            onSearchChange = { searchText, searchActive ->
                searchTextState = searchText
                searchActiveState = searchActive
            })


        TopBookContent(
            topBooksResource = topBooks,
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
            searchText = searchTextState, navController = navController,

            onAddToCartClicked = { book ->
                val cart = book.toCartItem()
                cartViewModel.addToCart(cart)

            }, isAddedToCart = { book ->
                cartViewModel.isAddedToCart(book)
            }
        )
        TopAuthorsContent(topAuthorsResource = topAuthors, navController = navController)
    }
}

fun Book.toCartItem(): Cart {

    return Cart(
        id = id,
        title = title,
        imageUrl = formats.imageJPEG,
        quantity = 1
    )
}

@Composable
fun TopBookContent(
    topBooksResource: Resource<List<Book>>,
    searchText: String,
    navController: NavController,
    onItemClick: (Book) -> Unit,
    onAddToCartClicked: (Book) -> Unit,
    isAddedToCart: (Book) -> Boolean,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        when (topBooksResource) {

            is Resource.Loading ->
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }

            is Resource.Success -> {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        text = "Top Books",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp, start = 16.dp)
                            .weight(1f)
                    )


                    Text(
                        text = "View all",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(top = 16.dp, end = 16.dp)
                            .weight(1f)
                            .clickable { navController.navigate("book_screen") },
                        textAlign = TextAlign.End

                    )
                }
                val filteredTopBooks = remember(searchText, topBooksResource.data) {
                    topBooksResource.data.filter {
                        it.title.contains(
                            searchText,
                            ignoreCase = true
                        )
                    }
                }
                val topBooks =
                    if (searchText.isBlank()) topBooksResource.data else filteredTopBooks

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),

                    ) {
                    items(topBooks) { book ->
                        MiniBookItem(
                            book = book,
                            modifier = Modifier.clickable {
                                onItemClick(book)
                            },
                            onAddToCartClicked = { onAddToCartClicked(book) },
                            isAddedToCart = isAddedToCart(book)

                        )
                    }
                }
            }

            is Resource.Error -> Text(text = "Error:") // Show error message
        }
    }
}


@Composable
fun TopAuthorsContent(
    topAuthorsResource: Resource<List<Authors>>,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

    }
    when (topAuthorsResource) {

        is Resource.Loading ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

        is Resource.Success -> {
            Row(
                Modifier
                    .background(Color.White)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Top Authors",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "View all",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { navController.navigate("author_screen") },
                    textAlign = TextAlign.End
                )
            }
            val topAuthors = topAuthorsResource.data
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(topAuthors) { author ->
                    AuthorItem(author = author)
                }

            }
        }

        is Resource.Error -> Text(text = "Error:") // Show error message
    }
}














