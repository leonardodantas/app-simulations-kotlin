package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.ClientDoesNotHaveLoan
import com.app.simulations.app.models.ICustomerLoanDetails
import com.app.simulations.app.models.impl.CustomerLoanDetails
import com.app.simulations.app.repositories.ICustomerLoanRepository
import com.app.simulations.app.usecases.ICustomerLoans
import org.springframework.stereotype.Service

@Service
class CustomerLoans(
    private val customerLoanRepository: ICustomerLoanRepository
) : ICustomerLoans {

    override fun findByCPF(cpf: String): ICustomerLoanDetails {
        val customerLoan = customerLoanRepository.findByCPF(cpf)
            .orElseThrow { ClientDoesNotHaveLoan("Cliente [${cpf}] não possui emprestimos disponiveis") }

        return CustomerLoanDetails.from(customerLoan)
    }
}