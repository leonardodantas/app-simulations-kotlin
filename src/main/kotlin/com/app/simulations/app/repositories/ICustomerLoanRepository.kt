package com.app.simulations.app.repositories

import com.app.simulations.domain.entities.CustomerLoan
import java.util.*

interface ICustomerLoanRepository {
    fun findByCPF(cpf: String): Optional<CustomerLoan>
    fun save(customerLoan: CustomerLoan): CustomerLoan
}