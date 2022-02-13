package com.app.simulations.infra.database

import com.app.simulations.domain.entities.Proposal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal
import java.util.*

interface ProposalRepositorySpringData : JpaRepository<Proposal, String> {
    fun findByIdAndSimulationsId(proposalId: String, simulationId: String): Optional<Proposal>
    fun findAllByCpf(page: Pageable, cpf: String): Page<Proposal>
    fun findByCpfAndTaxeAndLoanAmount(cpf: String, taxes: Double, loanAmount: BigDecimal): List<Proposal>
}