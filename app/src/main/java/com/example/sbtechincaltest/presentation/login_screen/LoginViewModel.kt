package com.example.sbtechincaltest.presentation.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {
    var state by mutableStateOf(LoginFormState())

    private val loginValidationChannel = Channel<LoginValidationEvent>()
    val loginChannelReceiver = loginValidationChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent){

        when(event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginFormEvent.Submit -> submitData()
        }
    }

    private fun submitData(){
        val isAllDataEntered = state.email.isNotBlank() && state.password.isNotBlank()
        if(isAllDataEntered) {
            viewModelScope.launch {
                loginValidationChannel.send(LoginValidationEvent.Success)
            }

        }
    }

    sealed class LoginValidationEvent {
        object Success: LoginValidationEvent()
    }

}

