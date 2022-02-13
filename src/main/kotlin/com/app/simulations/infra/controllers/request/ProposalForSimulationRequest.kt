package com.app.simulations.infra.controllers.request

import com.app.simulations.app.models.IProposalForSimulation
import com.app.simulations.infra.controllers.validations.AgeValid
import com.app.simulations.infra.controllers.validations.CEPValid
import com.app.simulations.infra.controllers.validations.CPFHasLoanValid
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ProposalForSimulationRequest(

    @field:CPFHasLoanValid
    @field:CPF
    override val cpf: String,
    @field:Positive
    override val loanAmount: BigDecimal,
    @field:NotNull
    override val modality: ModalityRequest,
    @field:AgeValid
    override val birthDate: LocalDate,
    @field:NotNull
    @field:CEPValid
    override val cep: String,
    @field:Positive
    override val income: BigDecimal


) : IProposalForSimulation