package com.app.simulations.domain

import java.math.BigDecimal

interface IAvailableLoans {

    fun available(age: Int, location: String): LoanModalities

    fun validateUse(income: BigDecimal): Boolean

}