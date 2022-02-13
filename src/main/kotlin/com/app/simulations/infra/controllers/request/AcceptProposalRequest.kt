package com.app.simulations.infra.controllers.request

import com.app.simulations.app.models.IAcceptProposalCustomer
import com.app.simulations.infra.controllers.validations.CPFHasLoanValid
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.NotBlank

class AcceptProposalRequest(
    @field:CPF
    @field:CPFHasLoanValid
    override val cpf: String,
    @field:NotBlank
    override val proposalId: String,
    @field:NotBlank
    override val simulationId: String
) : IAcceptProposalCustomer {
}