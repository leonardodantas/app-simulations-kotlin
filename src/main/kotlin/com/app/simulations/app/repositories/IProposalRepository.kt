package com.app.simulations.app.repositories

import com.app.simulations.app.models.IAcceptProposalCustomer
import com.app.simulations.domain.entities.Proposal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.math.BigDecimal
import java.util.*

interface IProposalRepository {

    fun save(proposal: Proposal): Proposal
    fun findByProposalIdAndSimulationId(acceptProposalCustomer: IAcceptProposalCustomer): Optional<Proposal>
    fun findAllByCPF(page: Pageable, cpf: String): Page<Proposal>
    fun findByProposalId(proposalId: String): Optional<Proposal>
    fun findByCPFAndTaxeAndLoanAmount(cpf: String, loanAmount: BigDecimal, taxes: Double): List<Proposal>
}