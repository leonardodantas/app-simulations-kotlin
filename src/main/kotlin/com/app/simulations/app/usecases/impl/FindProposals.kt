package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.ProposalNotFoundException
import com.app.simulations.app.models.IProposal
import com.app.simulations.app.models.impl.ProposalForCustomer
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.app.usecases.IFindProposals
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FindProposals
    (private val proposalRepository: IProposalRepository) :
    IFindProposals {

    override fun findAllByCPF(page: Pageable, cpf: String): Page<IProposal> {
        val proposal = proposalRepository.findAllByCPF(page, cpf)

        return proposal.map { ProposalForCustomer.from(it) }
    }

    override fun findbyProposalId(proposalId: String): IProposal {
        val proposal =  proposalRepository.findByProposalId(proposalId).orElseThrow { ProposalNotFoundException("Proposta [${proposalId}] não encontrada") }
        return ProposalForCustomer.from(proposal)
    }

}