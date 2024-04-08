package com.example.bookappcompose.feature.book.book.screen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.bookappcompose.R
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book
import com.example.domain.books.usecase.RemoveFromFavorite


@Composable
fun MiniBookItem(
    book: Book, modifier: Modifier,
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean,
) {

    Card(
        modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(220.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = book.formats.imageJPEG),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = book.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(80.dp)
                )
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.size(24.dp)
                )

                {
//                    Icon(
//                        painter = if (isFavorite)
//                            rememberAsyncImagePainter(model = R.drawable.ic_heart_dark)
//                        else rememberAsyncImagePainter(model = R.drawable.ic_heart_light),
//                        contentDescription = "Favorite",
//                        tint = if (isFavorite) Color.Red else Color.Gray
//
//
//                    )

                    Icon(
                        painter = rememberVectorPainter(if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder),
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.Gray
                    )
                }
            }

        }
    }
}







