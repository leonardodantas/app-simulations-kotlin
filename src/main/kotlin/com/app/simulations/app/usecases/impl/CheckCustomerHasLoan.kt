package com.app.simulations.app.usecases.impl

import com.app.simulations.app.repositories.ICustomerLoanRepository
import com.app.simulations.app.usecases.ICheckCustomerHasLoan
import org.springframework.stereotype.Service

@Service
class CheckCustomerHasLoan(
    private val customerRepository: ICustomerLoanRepository
) : ICheckCustomerHasLoan {

    override fun checkByCPF(cpf: String): Boolean {
        return customerRepository.findByCPF(cpf).isEmpty
    }
}