package com.example.sbtechincaltest.presentation.login_screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sbtechincaltest.presentation.login_screen.components.LoginTextField
import com.example.sbtechincaltest.presentation.login_screen.components.PasswordTextField
import com.example.sbtechincaltest.presentation.util.Screen
import com.example.sbtechincaltest.presentation.theme.JavaBlue
import com.example.sbtechincaltest.presentation.theme.JavaBlueOpacity

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    context: Context,
    navController: NavController,
    viewModel: LoginViewModel
){

    LaunchedEffect(key1 = context){
        viewModel.loginChannelReceiver.collect { event ->
            when(event){
                is LoginViewModel.LoginValidationEvent.Success -> navController.navigate(Screen.PhotoScreen.route)
            }
        }
    }

    val state = viewModel.state
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold() {
        Column(
            modifier = Modifier
                .padding(top = 80.dp, start = 20.dp, end = 20.dp, bottom = 30.dp)
        ) {
            it
            Column() {
                Text(
                    text = "Welcome Back",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Log in to your Student Beans account",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Column {

                LoginTextField(
                    viewmodel = viewModel,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )

                Spacer(modifier = Modifier.height(17.dp))

                PasswordTextField(
                    viewModel = viewModel,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val isFieldEntered = !state.email.isBlank() && !state.password.isBlank()
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(47.dp),
                onClick = {
                    viewModel.onEvent(LoginFormEvent.Submit)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (!state.email.isBlank() && !state.password.isBlank()) JavaBlue else JavaBlueOpacity
                )
            ) {
                Text(text = "Log in", color = Color.White)
            }


        }
    }
}