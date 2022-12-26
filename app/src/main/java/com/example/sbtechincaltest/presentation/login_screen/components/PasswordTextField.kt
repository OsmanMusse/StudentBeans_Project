package com.example.sbtechincaltest.presentation.login_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sbtechincaltest.presentation.login_screen.LoginFormEvent
import com.example.sbtechincaltest.presentation.login_screen.LoginViewModel
import com.example.sbtechincaltest.presentation.theme.DarkBlue
import com.example.sbtechincaltest.presentation.theme.LightBlue

@Composable
fun PasswordTextField(viewModel: LoginViewModel, keyboardActions: KeyboardActions){

    val state = viewModel.state

    OutlinedTextField(
        value = state.password,
        placeholder = {
            Text(
                text = "Password",
                color = Color.Black,
                fontSize = 15.sp
            )
        },
        onValueChange = { password ->
            viewModel.onEvent(LoginFormEvent.PasswordChanged(password))
        },

        modifier = Modifier
            .fillMaxWidth()
            .scale(scaleY = 0.95F, scaleX = 1F),
        shape = RoundedCornerShape(5.dp),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = LightBlue,
            focusedBorderColor = DarkBlue,
            unfocusedBorderColor = LightBlue,
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}