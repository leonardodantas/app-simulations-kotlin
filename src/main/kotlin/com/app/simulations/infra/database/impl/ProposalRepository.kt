package com.app.simulations.infra.database.impl

import com.app.simulations.app.exceptions.SaveEntityException
import com.app.simulations.app.models.IAcceptProposalCustomer
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.domain.entities.Proposal
import com.app.simulations.infra.database.ProposalRepositorySpringData
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*

@Component
class ProposalRepository(
    private val proposalRepositorySpringData: ProposalRepositorySpringData
) : IProposalRepository {

    override fun save(proposal: Proposal): Proposal {
        try {
            return proposalRepositorySpringData.save(proposal)
        } catch (ex: Exception) {
            throw SaveEntityException("Erro save proposal")
        }
    }

    override fun findByProposalIdAndSimulationId(acceptProposalCustomer: IAcceptProposalCustomer): Optional<Proposal> {
        return proposalRepositorySpringData.findByIdAndSimulationsId(acceptProposalCustomer.proposalId, acceptProposalCustomer.simulationId)
    }

    override fun findAllByCPF(page: Pageable, cpf: String): Page<Proposal> {
        return proposalRepositorySpringData.findAllByCpf(page, cpf)
    }

    override fun findByProposalId(proposalId: String): Optional<Proposal> {
        return proposalRepositorySpringData.findById(proposalId)
    }

    override fun findByCPFAndTaxeAndLoanAmount(cpf: String, loanAmount: BigDecimal, taxes: Double): List<Proposal> {
        return proposalRepositorySpringData.findByCpfAndTaxeAndLoanAmount(cpf, taxes, loanAmount)

    }

}