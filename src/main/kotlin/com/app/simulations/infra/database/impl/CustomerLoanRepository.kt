package com.app.simulations.infra.database.impl

import com.app.simulations.app.exceptions.SaveEntityException
import com.app.simulations.app.repositories.ICustomerLoanRepository
import com.app.simulations.domain.entities.CustomerLoan
import com.app.simulations.infra.database.CustomerLoanRepositorySpringData
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomerLoanRepository(
    private val customerLoanRepositorySpringData: CustomerLoanRepositorySpringData
) : ICustomerLoanRepository {

    override fun findByCPF(cpf: String): Optional<CustomerLoan> {
        return customerLoanRepositorySpringData.findByCpf(cpf)
    }

    override fun save(customerLoan: CustomerLoan): CustomerLoan {
        try {
            return customerLoanRepositorySpringData.save(customerLoan)
        } catch (ex: Exception) {
            throw SaveEntityException("Erro ao contratar emprestimo")
        }
    }


}