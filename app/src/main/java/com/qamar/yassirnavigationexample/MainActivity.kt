package com.qamar.yassirnavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.qamar.yassirnavigationexample.ui.navigation.authNavigationHost
import com.qamar.yassirnavigationexample.ui.navigation.homeNavigation
import com.qamar.yassirnavigationexample.ui.navigation.onBoardingNavigation
import com.qamar.yassirnavigationexample.ui.theme.YassirNavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            YassirNavigationExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = "on-boarding-graph"
                    ) {
                        onBoardingNavigation(navController)
                        authNavigationHost(navController)
                        homeNavigation(navController)
                    }
                }
            }
        }
    }
}
