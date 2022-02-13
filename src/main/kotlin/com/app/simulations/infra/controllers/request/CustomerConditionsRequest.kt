package com.app.simulations.infra.controllers.request

import com.app.simulations.app.models.ICustomerConditions
import com.app.simulations.infra.controllers.validations.AgeValid
import com.app.simulations.infra.controllers.validations.CEPValid
import com.app.simulations.infra.controllers.validations.CPFHasLoanValid
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CustomerConditionsRequest(

    @field:NotBlank
    @field:Length(min = 10, max = 60)
    override val name: String,

    @field:CPF
    @field:CPFHasLoanValid
    override val cpf: String,

    @field:AgeValid
    override val birthDate: LocalDate,

    @field:NotNull
    @field:CEPValid
    override val cep: String,

    @field:Positive
    override val income: BigDecimal

) : ICustomerConditions

