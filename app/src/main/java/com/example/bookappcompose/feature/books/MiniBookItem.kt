package com.example.bookappcompose.feature.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.domain.books.model.Book


@Composable
fun MiniBookItem(
    book: Book,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(200.dp),
            elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding( 16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = book.formats.imageJPEG),
                contentDescription = null, // Set to null as it's decorative
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = book.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(100.dp)
            )
        }
    }

}