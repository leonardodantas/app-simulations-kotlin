package com.app.simulations.infra.controllers.request

import com.app.simulations.app.models.IRenewProposalCustomer
import com.app.simulations.infra.controllers.validations.AgeValid
import com.app.simulations.infra.controllers.validations.CEPValid
import com.app.simulations.infra.controllers.validations.CPFHasLoanValid
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class RenewProposalRequest(

    @field:NotBlank
    override val proposalId: String,

    @field:CPFHasLoanValid
    @field:CPF
    override val cpf: String,
    @field:Positive
    @field:NotNull
    override val income: BigDecimal,
    @field:CEPValid
    override val cep: String,
    @field:AgeValid
    override val birthDate: LocalDate
) : IRenewProposalCustomer {
}