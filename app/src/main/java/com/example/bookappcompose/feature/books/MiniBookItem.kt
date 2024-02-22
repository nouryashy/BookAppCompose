package com.example.bookappcompose.feature.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.books.model.Book


@Composable
fun MiniBookItem(
    book: Book,
    modifier: Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(model = book.formats.imageJPEG),
        contentDescription = "Restaurant logo",
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
            .background(color = Color.Transparent)
    )

}