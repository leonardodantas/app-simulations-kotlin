package com.app.simulations.domain

import com.app.simulations.domain.impl.IncomeGreaterThan3000LessThan5000
import com.app.simulations.domain.impl.IncomeLessThan3000
import com.app.simulations.domain.impl.IncomeLessThan5000
import java.math.BigDecimal

class GetProfileCustomer(private val availableLoans: List<IAvailableLoans> = mutableListOf()) {

    companion object {
        fun from(income: BigDecimal): IAvailableLoans {
            val availableLoans: List<IAvailableLoans> = listOf(
                IncomeLessThan5000(), IncomeGreaterThan3000LessThan5000(), IncomeLessThan3000()
            )
            return availableLoans.first { it.validateUse(income) }
        }
    }

}