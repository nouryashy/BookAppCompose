package com.example.bookappcompose.feature.auther

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import com.example.bookappcompose.state.Resource
import com.example.domain.authors.model.Authors


@Composable

fun AuthorsScreen(
    navController: NavController,
    viewModel: AuthorsViewModel = hiltViewModel()
) {
    val state by viewModel.authors.collectAsState()

    when (val resource = state) {
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

            AuthorsContent(state = resource.data)

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
fun AuthorsContent(state: List<Authors>) {
    LazyColumn {
        items(state) { author ->
            AuthorItem(author = author)
        }

    }
}

