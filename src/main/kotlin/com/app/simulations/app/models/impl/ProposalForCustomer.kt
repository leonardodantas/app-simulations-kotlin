package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IAvailableModalities
import com.app.simulations.app.models.IProposal
import com.app.simulations.domain.entities.Proposal
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProposalForCustomer(
    override val id: String,
    override val cpf: String,
    override val modality: IAvailableModalities,
    override val loanAmount: BigDecimal,
    override val simulationDate: LocalDateTime
) : IProposal {

    companion object {
        fun from(proposal: Proposal): ProposalForCustomer {
            return ProposalForCustomer(
                proposal.id,
                proposal.cpf,
                AvailableModalities.from(proposal.modality),
                proposal.loanAmount,
                proposal.simulationDate
            )
        }
    }
}