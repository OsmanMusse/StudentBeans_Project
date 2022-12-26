package com.example.sbtechincaltest.presentation.login_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sbtechincaltest.presentation.login_screen.LoginFormEvent
import com.example.sbtechincaltest.presentation.login_screen.LoginViewModel
import com.example.sbtechincaltest.presentation.theme.JavaBlue
import com.example.sbtechincaltest.presentation.theme.JavaBlueOpacity

@Composable
fun SubmitBtn(viewModel: LoginViewModel){

    val state = viewModel.state

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