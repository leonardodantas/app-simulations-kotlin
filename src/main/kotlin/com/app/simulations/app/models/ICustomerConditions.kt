package com.app.simulations.app.models

import com.app.simulations.app.models.impl.CustomerConditions
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period

interface ICustomerConditions {

    val name: String
    val cpf: String
    val birthDate: LocalDate
    val cep: String
    val income: BigDecimal

    fun age(): Int {
        return Period.between(birthDate, LocalDate.now()).years
    }

    companion object {
        fun from(proposal: IProposalForSimulation ): ICustomerConditions {
            return CustomerConditions(
                name = "",
                cep = proposal.cep,
                birthDate = proposal.birthDate,
                cpf = proposal.cpf,
                income = proposal.income
            )
        }
    }

}