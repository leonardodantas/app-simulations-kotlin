package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IAvailableModalities
import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.models.ISimulations
import com.app.simulations.domain.entities.Proposal
import java.math.BigDecimal
import java.time.LocalDateTime

class ProposalForCustomerWithSimulations(
    override val id: String,
    override val cpf: String,
    override val rate: Double,
    override val loanAmount: BigDecimal,
    override val simulationDate: LocalDateTime,
    override val simulations: MutableList<ISimulations>, override val modality: IAvailableModalities,
    override val iofTotal: BigDecimal
) : IProposalWithSimulations {

    companion object {
        fun from(proposal: Proposal): ProposalForCustomerWithSimulations {
            return ProposalForCustomerWithSimulations(
                proposal.id,
                proposal.cpf,
                proposal.taxe,
                proposal.loanAmount,
                proposal.simulationDate,
                proposal.simulations.map { SimulationsOfProposal.from(it) }.toMutableList(),
                AvailableModalities.from(proposal.modality),
                proposal.iofFixed
            )
        }
    }
}