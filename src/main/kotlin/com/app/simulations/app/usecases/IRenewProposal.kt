package com.app.simulations.app.usecases

import com.app.simulations.app.models.IRenewProposalCustomer

interface IRenewProposal {

    fun renew(renewProposalCustomer: IRenewProposalCustomer)
}