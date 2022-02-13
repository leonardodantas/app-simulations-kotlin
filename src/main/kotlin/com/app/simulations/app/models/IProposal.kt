package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDateTime

interface IProposal {
    val id: String
    val cpf: String
    val modality: IAvailableModalities
    val loanAmount: BigDecimal
    val simulationDate: LocalDateTime
}