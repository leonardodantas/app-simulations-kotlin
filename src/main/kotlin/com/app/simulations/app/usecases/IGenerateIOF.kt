package com.app.simulations.app.usecases

import java.math.BigDecimal
import java.time.LocalDate

interface IGenerateIOF {

    fun getIOFFixed(loanAmount: BigDecimal): BigDecimal

    fun getIOFDaily(loanAmount: BigDecimal, lastDueDate: LocalDate): BigDecimal
}