package com.app.simulations.app.usecases

import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.models.IProposalForSimulation

interface IGenerateSimulations {

    fun generateByProposal(proposal: IProposalForSimulation): IProposalWithSimulations
}