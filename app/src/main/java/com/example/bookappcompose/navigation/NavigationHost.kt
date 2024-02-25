package com.example.bookappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookappcompose.feature.auther.AuthorsScreen
import com.example.bookappcompose.feature.books.BookDetailsScreen
import com.example.bookappcompose.feature.books.BooksScreen
import com.example.bookappcompose.main.composoble.BottomNavigationView
import com.example.bookappcompose.main.screens.MainScreen

const val Main_ROUTE = "main_screen"
const val BOOK_ROUTE = "books_screen"
const val BOOK_DETAIL_ROUTE = "book_detail_screen"
const val AUTHOR_ROUTE = "author_screen"

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Main_ROUTE) {

        composable(route = Main_ROUTE) {
            MainScreen(
                navController = navController,
                booksViewModel = hiltViewModel(),
                authorsViewModel = hiltViewModel()
            )
        }
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

        composable(route = AUTHOR_ROUTE) {
            AuthorsScreen(navController = navController, viewModel = hiltViewModel())
        }


    }

    BottomNavigationView(navController = navController)

}