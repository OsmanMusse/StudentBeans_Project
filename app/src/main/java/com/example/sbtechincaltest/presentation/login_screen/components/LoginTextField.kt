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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sbtechincaltest.presentation.login_screen.LoginFormEvent
import com.example.sbtechincaltest.presentation.login_screen.LoginViewModel
import com.example.sbtechincaltest.presentation.theme.DarkBlue
import com.example.sbtechincaltest.presentation.theme.LightBlue

@Composable
fun LoginTextField(viewmodel: LoginViewModel, keyboardActions: KeyboardActions){

    val state = viewmodel.state
    OutlinedTextField(
        value = state.email,
        placeholder = {
            Text(text = "Email", color = Color.Black, fontSize = 15.sp)
        },
        onValueChange = { email ->
            viewmodel.onEvent(LoginFormEvent.EmailChanged(email))
        },
        modifier = Modifier
            .fillMaxWidth()
            .scale(scaleY = 0.93F, scaleX = 1F),
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = LightBlue,
            focusedBorderColor = DarkBlue,
            unfocusedBorderColor = LightBlue,
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = keyboardActions
        )

}