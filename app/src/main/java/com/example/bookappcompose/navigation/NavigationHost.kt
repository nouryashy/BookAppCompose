package com.example.bookappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookappcompose.feature.author.screen.AuthorsScreen
import com.example.bookappcompose.feature.book.book.screen.BookDetailsScreen
import com.example.bookappcompose.feature.book.book.screen.BooksScreen
import com.example.bookappcompose.feature.book.fav.screens.FavoriteBooksScreen
import com.example.bookappcompose.feature.category.categorybook.screen.CategoryBookScreen
import com.example.bookappcompose.feature.category.categorylabel.screen.CategoryLabelScreen
import com.example.bookappcompose.main.composoble.BottomNavigationView
import com.example.bookappcompose.main.screens.MainScreen

const val Main_ROUTE = "main_screen"
const val BOOK_ROUTE = "book_screen"
const val BOOK_DETAIL_ROUTE = "book_detail_screen"
const val AUTHOR_ROUTE = "author_screen"
const val CATEGORY_LABEL_ROUTE = "category_Label_screen"
const val CATEGORY_BOOK_ROUTE = "category_book_screen"
const val FAVORITE_BOOK_ROUTE = "favorite_screen"

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Main_ROUTE) {

        composable(route = Main_ROUTE) {
            MainScreen(
                navController = navController,
                booksViewModel = hiltViewModel(),
                authorsViewModel = hiltViewModel(),
                favoriteBookViewModel = hiltViewModel()
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

        composable(route = CATEGORY_LABEL_ROUTE) {
            CategoryLabelScreen(navController = navController, viewModel = hiltViewModel())
        }

        composable(
            route = "$CATEGORY_BOOK_ROUTE/{categoryId}/{categoryName}/{categoryImage}",
            arguments = listOf(
                navArgument(name = "categoryId") {
                    type = NavType.StringType
                }, navArgument(name = "categoryName") {
                    type = NavType.StringType
                }, navArgument(name = "categoryImage") {
                    type = NavType.IntType
                })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            val categoryName = backStackEntry.arguments?.getString("categoryName")
            val categoryImage = backStackEntry.arguments?.getInt("categoryImage")

            CategoryBookScreen(navController = navController,
                viewModel = hiltViewModel(),
                categoryId = categoryId!!.toInt(),
                categoryName = categoryName!!,
                categoryImage = categoryImage!!
            )
        }

        composable(route = FAVORITE_BOOK_ROUTE) {
            FavoriteBooksScreen(navController = navController, viewModel = hiltViewModel())
        }

    }

    BottomNavigationView(navController = navController)

}