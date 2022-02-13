package com.app.simulations.app.models

import com.app.simulations.app.models.impl.AvailableModalities
import java.math.BigDecimal
import java.time.LocalDateTime

interface ICustomerLoanDetails {

    val id: String
    val cpf: String
    val simulation: ISimulations
    val modality: AvailableModalities
    val loanAmount: BigDecimal
    val simulationDate: LocalDateTime
    val acceptanceDate: LocalDateTime
}