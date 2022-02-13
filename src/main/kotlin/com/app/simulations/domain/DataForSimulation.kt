package com.app.simulations.domain

import java.math.BigDecimal

data class DataForSimulation(
    val cpf: String,
    val modality: Modality,
    val loanAmount: BigDecimal
)