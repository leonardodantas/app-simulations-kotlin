package com.app.simulations.infra.controllers.validations

import com.app.simulations.app.usecases.ICheckCustomerHasLoan
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CPFHasLoanValidator(
    private val customerHasLoan: ICheckCustomerHasLoan
) : ConstraintValidator<CPFHasLoanValid, String> {

    override fun isValid(cpf: String?, p1: ConstraintValidatorContext?): Boolean {
        if(cpf.isNullOrEmpty()) {
            return false
        }
        return customerHasLoan.checkByCPF(cpf)
    }
}