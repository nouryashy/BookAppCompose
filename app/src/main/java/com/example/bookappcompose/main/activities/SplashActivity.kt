package com.example.bookappcompose.main.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bookappcompose.main.composoble.SetStatusBarColor
import com.example.bookappcompose.main.screens.SplashScreen
import com.example.bookappcompose.ui.theme.BookAppComposeTheme
import com.example.bookappcompose.ui.theme.GrayL

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAppComposeTheme {
                // A surface container using the 'background' color from the theme
                SetStatusBarColor(color = GrayL)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen(activity = this@SplashActivity)
                }
            }
        }
    }

}


