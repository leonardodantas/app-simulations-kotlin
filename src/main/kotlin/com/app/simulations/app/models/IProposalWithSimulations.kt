package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDateTime

interface IProposalWithSimulations {

    val id: String
    val cpf: String
    val modality: IAvailableModalities
    val rate: Double
    val loanAmount: BigDecimal
    val simulationDate: LocalDateTime
    val simulations: MutableList<ISimulations>
    val iofTotal: BigDecimal

}