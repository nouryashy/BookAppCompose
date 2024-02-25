package com.example.bookappcompose.feature.auther

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import com.example.bookappcompose.state.Resource
import com.example.domain.authors.model.Authors


@Composable

fun AuthorsScreen(
    navController: NavController,
    viewModel: AuthorsViewModel = hiltViewModel()
) {
    val authors by viewModel.authors.collectAsState()
    AuthorsContent(authorsResource = authors)
}

@Composable
fun AuthorsContent(authorsResource: Resource<List<Authors>>) {

    when (authorsResource) {
        is Resource.Loading ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        is Resource.Success -> {
            val authors = authorsResource.data
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(authors) { author ->
                    AuthorItem(author = author)
                }

            }
        }
        is Resource.Error -> Text(text = "Error:") // Show error message
    }
}

