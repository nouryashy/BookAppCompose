package com.example.bookappcompose.main.composoble

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarView(
    searchText: String,
    searchActive: Boolean,
    onSearchChange: (String, Boolean) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 8.dp)) {


        SearchBar(
            query = searchText,
            onQueryChange = { onSearchChange(it, searchActive) },
            onSearch = { onSearchChange(searchText, false) },
            active = searchActive,
            onActiveChange =
            {
                onSearchChange(searchText, it)
            }, placeholder = {
                Text(text = "Search")
            }, leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            }, trailingIcon = {
                if (searchActive) {
                    Icon(modifier = Modifier.clickable {
                        if (searchText.isNotEmpty()) {
                            onSearchChange("", searchActive)
                        } else {
                            onSearchChange(searchText, false)
                        }

                    }, imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                }
            }) {
        }
    }
}