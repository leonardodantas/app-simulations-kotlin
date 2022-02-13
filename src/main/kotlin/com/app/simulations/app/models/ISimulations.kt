package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDate

interface ISimulations {

    val id: String
    val amount: BigDecimal
    val numberInstallments: Int
    val firstDueDate: LocalDate
    val installments: MutableList<IInstallments>
    val iofDaily: BigDecimal
}