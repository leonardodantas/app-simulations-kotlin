package com.app.simulations.app.usecases

import com.app.simulations.app.models.ICustomerLoanDetails

interface ICustomerLoans {

    fun findByCPF(cpf: String): ICustomerLoanDetails
}