package com.example.sbtechincaltest.domain.use_case

class ValidatePassword {

    fun execute(password:String): ValidationResult{
        if(password.isBlank()){
            return ValidationResult(successful = false, errorMessage = "The password can't be blank")
        } else {
            return ValidationResult(successful = true)
        }
    }
}