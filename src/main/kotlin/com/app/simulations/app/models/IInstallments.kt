package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDate

interface IInstallments {

    val id: String
    val dueDate: LocalDate
    val installmentValue: BigDecimal
}