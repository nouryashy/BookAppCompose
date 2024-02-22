package com.example.bookappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookappcompose.feature.books.BookDetailsScreen
import com.example.bookappcompose.feature.books.BooksScreen

const val BOOK_ROUTE = "books_List"
const val BOOK_DETAIL_ROUTE = "book_detail"

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BOOK_ROUTE) {
        composable(route = BOOK_ROUTE) {
            BooksScreen(navController = navController, viewModel = hiltViewModel())
        }
        composable(
            route = "$BOOK_DETAIL_ROUTE/{bookId}/{bookTitle}/{bookDes}/{bookImage}",
            arguments = listOf(
                navArgument(name = "bookId") {
                    type = NavType.StringType
                }, navArgument(name = "bookTitle") {
                    type = NavType.StringType
                }, navArgument(name = "bookDes") {
                    type = NavType.StringType
                }, navArgument(name = "bookImage") {
                    type = NavType.StringType
                })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId")
            val bookTitle = backStackEntry.arguments?.getString("bookTitle")
            val bookDes = backStackEntry.arguments?.getString("bookDes")
            val bookImage = backStackEntry.arguments?.getString("bookImage")

            BookDetailsScreen(
                bookId = bookId!!.toInt(),
                bookTitle = bookTitle!!,
                bookDes = bookDes!!,
                bookImage = bookImage!!
            )
        }
    }

}