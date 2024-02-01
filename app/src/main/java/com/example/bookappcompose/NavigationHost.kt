package com.example.bookappcompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val MAIN_ROUTE = "main"
const val BOOK_DETAIL_ROUTE = "book_detail/{bookId}"

@Composable
fun NavigationHost() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MAIN_ROUTE) {
        composable(MAIN_ROUTE) {
            BooksScreen(navController = navController, viewModel = hiltViewModel())
        }
        composable(BOOK_DETAIL_ROUTE) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val bookId = arguments.getInt("bookId")
            BookDetailsScreen(navController = navController, bookId = bookId)
        }
    }
}