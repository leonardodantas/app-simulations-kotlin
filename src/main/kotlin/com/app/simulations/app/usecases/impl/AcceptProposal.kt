package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.ProposalNotFoundException
import com.app.simulations.app.models.IAcceptProposalCustomer
import com.app.simulations.app.repositories.ICustomerLoanRepository
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.app.usecases.IAcceptProposal
import com.app.simulations.domain.entities.CustomerLoan
import org.springframework.stereotype.Service

@Service
class AcceptProposal(
    private val proposalRepository: IProposalRepository,
    private val customerLoanRepository: ICustomerLoanRepository
) : IAcceptProposal {

    override fun accept(acceptProposalCustomer: IAcceptProposalCustomer) {
        val proposal = proposalRepository.findByProposalIdAndSimulationId(acceptProposalCustomer).orElseThrow{ProposalNotFoundException("Proposta ou simulação não encontrada")}
        proposal.isWithinTheDeadline()
        val customerLoan = CustomerLoan.of(proposal, acceptProposalCustomer.simulationId)
        customerLoanRepository.save(customerLoan)
    }
}