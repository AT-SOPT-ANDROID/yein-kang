package org.sopt.at.presentation.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.at.presentation.R
import org.sopt.at.presentation.my.MyActivity
import org.sopt.at.presentation.signup.SignUpActivity
import org.sopt.at.presentation.signup.SignUpState
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.util.KeyUtil.DEFAULT_STRING
import org.sopt.at.presentation.util.KeyUtil.ID
import org.sopt.at.presentation.util.KeyUtil.PASSWORD

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    private val signUpState: MutableState<SignUpState> by lazy {
        mutableStateOf(SignUpState())
    }

    private val signUpLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val id = data?.getStringExtra(ID) ?: DEFAULT_STRING
            val password = data?.getStringExtra(PASSWORD) ?: DEFAULT_STRING
            signUpState.value = signUpState.value.copy(uiState = signUpState.value.uiState.copy(id = id, password = password))
        }
    }

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
                    SignInRoute(
                        paddingValues = innerPadding,
                        navigateUp = { finish() },
                        navigateMy = { id, password ->
                            if(id == signUpState.value.uiState.id && password == signUpState.value.uiState.password){
                                Intent(this, MyActivity::class.java).apply {
                                    putExtra(ID, id)
                                    startActivity(this)
                                    finish()
                                }
                            } else {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(message = getString(R.string.signin_fail))
                                }
                            }
                        },
                        navigateSignUp = {
                            signUpLauncher.launch(Intent(this, SignUpActivity::class.java))
                        },
                        navigateSnackBar = { message ->
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(message = getString(message))
                            }
                        }
                    )
                }
            }
        }
    }
}