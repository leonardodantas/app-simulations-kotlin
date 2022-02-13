package com.app.simulations.app.usecases.impl

import com.app.simulations.app.exceptions.SimilarProposalException
import com.app.simulations.app.models.IAvailableModalities
import com.app.simulations.app.models.ICustomerConditions
import com.app.simulations.app.models.IProposalForSimulation
import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.models.impl.ProposalForCustomerWithSimulations
import com.app.simulations.app.repositories.IProposalRepository
import com.app.simulations.app.usecases.ICheckAvailableLoanTypes
import com.app.simulations.app.usecases.IGenerateSimulations
import com.app.simulations.domain.DataForSimulation
import com.app.simulations.domain.ISimulateLoan
import com.app.simulations.domain.Modality
import org.springframework.stereotype.Service

@Service
class GenerateSimulations(
    private val chechAvailableLoanTypes: ICheckAvailableLoanTypes,
    private val simulationLoan: ISimulateLoan,
    private val proposalRepository: IProposalRepository,
) : IGenerateSimulations {

    override fun generateByProposal(proposal: IProposalForSimulation): IProposalWithSimulations {
        val dataForSimulation = createDataForSimulation(proposal)
        val simulations = simulationLoan.simulate(dataForSimulation)
        proposalRepository.save(simulations)
        return ProposalForCustomerWithSimulations.from(simulations)

    }

    private fun createDataForSimulation(proposal: IProposalForSimulation): DataForSimulation {
        val checkCustomer = chechAvailableLoanTypes.checkCustomer(ICustomerConditions.from(proposal))
        val modality = checkCustomer.findModalyByDescription(proposal.getModalityDescription())

        this.checkIfThereIsSimilarProposal(proposal, modality)

        return DataForSimulation(proposal.cpf, Modality.valueOf(modality.type), proposal.loanAmount)
    }

    private fun checkIfThereIsSimilarProposal(proposal: IProposalForSimulation, modality: IAvailableModalities) {

        proposalRepository.findByCPFAndTaxeAndLoanAmount(proposal.cpf, proposal.loanAmount, modality.taxes)
            .filter { it.isValid() }
            .let {
                if (it.isNotEmpty()) {
                    throw SimilarProposalException("O cliente já possui uma proposta semelhante com o id [${it.get(0).id}]")
                }
            }
    }

}
