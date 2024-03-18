package com.example.bookappcompose.feature.book.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun BookDetailsScreen(
    bookId: Int,
    bookTitle: String,
    bookDes: String,
    bookImage: String,
) {

    BookDetailContent(
        bookId = bookId,
        bookTitle = bookTitle,
        bookDes = bookDes,
        bookImage = bookImage
    )
}

@Composable
fun BookDetailContent(bookId: Int, bookTitle: String, bookDes: String, bookImage: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = bookImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = bookTitle, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = bookDes, fontSize = 12.sp
        )

    }
}
