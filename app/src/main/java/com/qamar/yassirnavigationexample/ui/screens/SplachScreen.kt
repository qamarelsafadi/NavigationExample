package com.qamar.yassirnavigationexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.qamar.yassirnavigationexample.ui.util.withDelay

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        { onFinish() }.withDelay(5000)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Compose Navigaiton", color = Color.White)
    }
}