package com.spindler.sholi.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.spindler.sholi.app.navigation.ShoLiNavHost
import com.spindler.sholi.app.ui.theme.ShoLiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoLiTheme {
                Surface {
                    val navController = rememberNavController()
                    ShoLiNavHost(navController)
                }
            }
        }
    }
}
