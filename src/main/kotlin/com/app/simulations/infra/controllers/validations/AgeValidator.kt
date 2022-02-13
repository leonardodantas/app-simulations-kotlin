package com.app.simulations.infra.controllers.validations

import java.time.LocalDate
import java.time.Period
import java.util.Objects
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class AgeValidator : ConstraintValidator<AgeValid, LocalDate> {

    override fun isValid(birthDate: LocalDate?, p1: ConstraintValidatorContext?): Boolean {
        if (Objects.isNull(birthDate)) {
            return false
        }
        return Period.between(birthDate, LocalDate.now()).years > 17
    }
}