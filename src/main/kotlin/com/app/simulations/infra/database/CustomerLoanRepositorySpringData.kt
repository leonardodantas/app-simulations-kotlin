package com.app.simulations.infra.database

import com.app.simulations.domain.entities.CustomerLoan
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerLoanRepositorySpringData : JpaRepository<CustomerLoan, String> {
    fun findByCpf(cpf: String): Optional<CustomerLoan>
}