package com.app.simulations.app.usecases

import com.app.simulations.app.models.IAcceptProposalCustomer

interface IAcceptProposal {

    fun accept(acceptProposalCustomer: IAcceptProposalCustomer)
}