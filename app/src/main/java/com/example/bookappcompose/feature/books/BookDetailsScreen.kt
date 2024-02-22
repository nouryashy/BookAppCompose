package com.example.bookappcompose.feature.books

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Parcelable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bookappcompose.state.Resource
import com.example.domain.books.model.Book
import kotlinx.coroutines.flow.firstOrNull

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
