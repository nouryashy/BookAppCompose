package com.example.bookappcompose.feature.category.categorylabel.screen.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookappcompose.R
import com.example.domain.category.categorylabel.model.CategoryLabel

@Composable
fun CategoryLabelItem(categoryLabel: CategoryLabel, modifier: Modifier) {
    Card(
        modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(120.dp),
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

            val imageResId = getImageResId(categoryLabel.imageResourceName)
            val painter = painterResource(id = imageResId)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Text(
                text = categoryLabel.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp), fontSize = 16.sp,
                textAlign = TextAlign.Center

            )
        }
    }

}

@Composable
fun getImageResId(imageResourceName: String): Int {
    return when (imageResourceName) {
        "Drama_image" -> R.drawable.ic_drama
        "Religious_image" -> R.drawable.ic_religious
        "History_image" -> R.drawable.ic_history
        "Children_image" -> R.drawable.ic_children
        "Fiction_image" -> R.drawable.ic_fiction
        "Medicine_image" -> R.drawable.ic_medical
        "Sports_image" -> R.drawable.ic_sports
        "Cooking_image" -> R.drawable.ic_cooking
        "Science_image" -> R.drawable.ic_science

        else -> R.drawable.ic_drama
    }
}