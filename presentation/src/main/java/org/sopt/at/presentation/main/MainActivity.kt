package org.sopt.at.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            val navigator: MainNavigator = rememberMainNavigator()
            AtSoptAndroidTheme {
                MainScreen(
                    navigator = navigator
                )
            }
        }
    }
}
