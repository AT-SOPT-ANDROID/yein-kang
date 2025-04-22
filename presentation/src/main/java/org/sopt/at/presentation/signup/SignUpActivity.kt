package org.sopt.at.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.at.presentation.signin.SignInRoute
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.util.KeyUtil.ID
import org.sopt.at.presentation.util.KeyUtil.PASSWORD

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtSoptAndroidTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    SignUpRoute(
                        paddingValues = innerPadding,
                        navigateUp = {
                            //finish()
                        },
                        navigateSignIn = { id, password ->
                            intent.apply{
                              putExtra(ID, id)
                              putExtra(PASSWORD, password)
                              setResult(RESULT_OK, this)
                            }
                            finish()
                        },
                        navigateSnackBar = { message ->
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(message = getString(message))
                            }
                        },
                    )
                }
            }
        }
    }
}