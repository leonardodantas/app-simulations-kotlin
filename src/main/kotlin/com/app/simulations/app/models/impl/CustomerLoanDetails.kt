package com.app.simulations.app.models.impl

import com.app.simulations.app.models.ICustomerLoanDetails
import com.app.simulations.app.models.ISimulations
import com.app.simulations.domain.entities.CustomerLoan
import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerLoanDetails(
    override val id: String,
    override val cpf: String,
    override val simulation: ISimulations,
    override val modality: AvailableModalities,
    override val loanAmount: BigDecimal,
    override val simulationDate: LocalDateTime,
    override val acceptanceDate: LocalDateTime
) : ICustomerLoanDetails {

    companion object {
        fun from(customerLoan: CustomerLoan): CustomerLoanDetails{
            return CustomerLoanDetails(
                customerLoan.id,
                customerLoan.cpf,
                SimulationsOfProposal.from(customerLoan.simulation),
                AvailableModalities.from(customerLoan.modality),
                customerLoan.loanAmount,
                customerLoan.simulationDate,
                customerLoan.acceptanceDate
            )

        }
    }
}