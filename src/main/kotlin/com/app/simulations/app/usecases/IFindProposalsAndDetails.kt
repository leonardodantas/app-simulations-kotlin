package com.app.simulations.app.usecases

import com.app.simulations.app.models.IProposalWithSimulations

interface IFindProposalsAndDetails {

    fun findByProposalId(proposalId: String): IProposalWithSimulations
}