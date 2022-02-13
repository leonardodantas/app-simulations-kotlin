package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.ProposalNotFoundException
import com.app.simulations.app.models.IRenewProposalCustomer
import com.app.simulations.app.models.impl.CustomerConditions
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.app.usecases.ICheckAvailableLoanTypes
import com.app.simulations.app.usecases.IRenewProposal
import com.app.simulations.domain.entities.Proposal
import org.springframework.stereotype.Service

@Service
class RenewProposal(
    private val proposalRepository: IProposalRepository,
    private val checkAvailableLoanTypes: ICheckAvailableLoanTypes,
) : IRenewProposal {
    override fun renew(renewProposalCustomer: IRenewProposalCustomer) {
        val proposal = this.checkCompatibilityBetweenModalities(renewProposalCustomer)
        proposal.isWithinTheRenewalPeriod()
        proposalRepository.save(proposal.renew())
    }

    private fun checkCompatibilityBetweenModalities(renewProposalCustomer: IRenewProposalCustomer): Proposal {
        val proposal = proposalRepository.findByProposalId(renewProposalCustomer.proposalId)
            .orElseThrow { ProposalNotFoundException("Proposta [${renewProposalCustomer.proposalId}] não encontrada") }
        val modalities = checkAvailableLoanTypes.checkCustomer(CustomerConditions.from(renewProposalCustomer))
        modalities.compatible(proposal.modality)
        return proposal
    }

}