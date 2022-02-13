package com.app.simulations.app.models.impl

import com.app.simulations.app.models.ICustomerConditions
import com.app.simulations.app.models.IRenewProposalCustomer
import java.math.BigDecimal
import java.time.LocalDate

class CustomerConditions(
    override val name: String,
    override val cpf: String,
    override val birthDate: LocalDate,
    override val cep: String,
    override val income: BigDecimal
) : ICustomerConditions {

    companion object {
        fun from(renewProposal: IRenewProposalCustomer): ICustomerConditions {
            return CustomerConditions(
                "",
                renewProposal.cpf,
                renewProposal.birthDate,
                renewProposal.cep,
                renewProposal.income
            )
        }
    }
}