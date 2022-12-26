package com.example.sbtechincaltest.domain.use_case

class ValidateEmail {
    
    fun execute(email:String): ValidationResult{
        if(email.isBlank()){
            return ValidationResult(successful = false, errorMessage = "The email can't be blank")
        } else {
            return ValidationResult(successful = true)
        }
    }
}