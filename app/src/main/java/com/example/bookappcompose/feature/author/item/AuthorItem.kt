package com.example.bookappcompose.feature.author.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.authors.model.Authors

@Composable
fun AuthorItem(
    author: Authors,

    ) {
    Card(
        Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            for (author in author.authors) {
                Text(text = author.name, fontSize = 20.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(8.dp))
                Row() {
                    val birthDate = author.birth_year.toString()
                    Text(
                        text = "birth Date : $birthDate",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .weight(1f)
                    )
                    val deathDate = author.death_year.toString()
                    Text(
                        text = "death Date : $deathDate",
                        fontSize = 14.sp, color = Color.Gray, modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }


    }
}