package com.app.simulations.app.usecases

interface ICheckCustomerHasLoan {

    fun checkByCPF(cpf: String): Boolean
}