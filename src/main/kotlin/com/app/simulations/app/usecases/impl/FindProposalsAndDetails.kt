package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.ProposalNotFoundException
import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.models.impl.ProposalForCustomerWithSimulations
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.app.usecases.IFindProposalsAndDetails
import org.springframework.stereotype.Service

@Service
class FindProposalsAndDetails(
    private val proposalRepository: IProposalRepository
) : IFindProposalsAndDetails {

    override fun findByProposalId(proposalId: String): IProposalWithSimulations {
        val proposal = proposalRepository.findByProposalId(proposalId)
            .orElseThrow { ProposalNotFoundException("Proposta [${proposalId}] não encontrada") }

        return ProposalForCustomerWithSimulations.from(proposal)
    }
}