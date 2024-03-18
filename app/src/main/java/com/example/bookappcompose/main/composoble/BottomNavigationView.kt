package com.example.bookappcompose.main.composoble

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bookappcompose.R
import com.example.bookappcompose.ui.theme.GrayL
import com.example.bookappcompose.ui.theme.GrayM

@Composable
fun BottomNavigationView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {

        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = GrayM
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomNavigationItem(
                selected = currentRoute == "main_screen",
                onClick = {
                    navController.navigate("main_screen") {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            saveState = true
                        }
                        launchSingleTop = false
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == "main_screen")
                                R.drawable.ic_home_dark else R.drawable.ic_home_light
                        ),
                        contentDescription = "Icon", modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text("Main") }
            )
            BottomNavigationItem(
                selected = currentRoute == "category_Label_screen",
                onClick = {
                    navController.navigate("category_Label_screen") {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            saveState = true
//                            saveState = false
                        }
//                        launchSingleTop = true
                        launchSingleTop = false
                        restoreState = true
//                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == "category_Label_screen")
                                R.drawable.ic_category_dark else R.drawable.ic_category_light
                        ),
                        contentDescription = "Icon", modifier = Modifier.size(20.dp)
                    )
                },
                label = { Text("Category") }
            )

            BottomNavigationItem(
                selected = currentRoute == "book_screen",
                onClick = {
                    navController.navigate("book_screen") {
                        popUpTo(navController.graph.startDestinationRoute!!) {
//                            saveState = true
                            saveState = false
                        }
//                        launchSingleTop = true
                        launchSingleTop = false
//                        restoreState = true
                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == "book_screen")
                                R.drawable.ic_book_dark else R.drawable.ic_book_light
                        ),
                        contentDescription = "Icon", modifier = Modifier.size(23.dp)
                    )
                },
                label = { Text("Books") }
            )

            BottomNavigationItem(
                selected = currentRoute == "author_screen",
                onClick = {
                    navController.navigate("author_screen") {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            //                            saveState = true
                            saveState = false
                        }
//                        launchSingleTop = true
                        launchSingleTop = false
//                        restoreState = true
                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == "author_screen")
                                R.drawable.ic_author_dark else R.drawable.ic_author_light
                        ),
                        contentDescription = "Icon", modifier = Modifier.size(23.dp)
                    )
                },
                label = { Text("Authors") }
            )

            BottomNavigationItem(
                selected = currentRoute == "cart_screen",
                onClick = {
                    navController.navigate("cart_screen") {
                        popUpTo(navController.graph.startDestinationRoute!!) {

                            saveState = true
                        }
                        launchSingleTop = false


                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == "cart_screen")
                                R.drawable.ic_cart_dark else R.drawable.ic_cart_light
                        ),
                        contentDescription = "Icon", modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text("Cart") }
            )
        }
    }
}