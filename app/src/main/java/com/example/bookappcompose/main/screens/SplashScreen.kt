package com.example.bookappcompose.main.screens

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.bookappcompose.R
import com.example.bookappcompose.main.activities.MainActivity
import com.example.bookappcompose.main.activities.SplashActivity
import com.example.bookappcompose.ui.theme.GrayL
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( activity: SplashActivity) {
    SplashContent( activity = activity)
}

@Composable
fun SplashContent( activity: SplashActivity) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        activity.startActivity(Intent(activity, MainActivity::class.java))

    }

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GrayL)
    ) {


        Image(
            painter = rememberAsyncImagePainter(R.drawable.ic_loader, imageLoader),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }

}