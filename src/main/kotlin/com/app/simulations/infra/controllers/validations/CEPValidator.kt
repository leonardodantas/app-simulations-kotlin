package com.app.simulations.infra.controllers.validations

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CEPValidator : ConstraintValidator<CEPValid, String> {

    override fun isValid(cep: String, p1: ConstraintValidatorContext?): Boolean {
        if(cep.isNullOrEmpty() || cep.length > 8) {
            return false
        }
        return cep.matches(Regex("[0-9]{5}[0-9]{3}"))
    }
}