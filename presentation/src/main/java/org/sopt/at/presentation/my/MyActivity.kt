package org.sopt.at.presentation.my

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.presentation.R
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.util.KeyUtil.ID

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val id = intent.getStringExtra(ID) ?: getString(R.string.id)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtSoptAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = id,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
