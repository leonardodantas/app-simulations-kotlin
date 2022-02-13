package com.app.simulations.app.usecases

import com.app.simulations.app.models.IProposal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IFindProposals {

    fun findAllByCPF(page: Pageable, cpf: String): Page<IProposal>
    fun findbyProposalId(proposalId: String): IProposal
}