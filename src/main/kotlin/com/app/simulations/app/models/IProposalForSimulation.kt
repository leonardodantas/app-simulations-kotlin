package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDate

interface IProposalForSimulation {

    val cpf: String
    val loanAmount: BigDecimal
    val modality: IModality
    val birthDate: LocalDate
    val cep: String
    val income: BigDecimal

    fun getModalityDescription(): String {
        return modality.getDescription()
    }
}