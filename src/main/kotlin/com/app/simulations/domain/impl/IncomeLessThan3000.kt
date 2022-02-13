package com.app.simulations.domain.impl

import com.app.simulations.domain.IAvailableLoans
import com.app.simulations.domain.Modality
import com.app.simulations.domain.LoanModalities
import java.math.BigDecimal

class IncomeLessThan3000() : IAvailableLoans {

    override fun available(age: Int, location: String): LoanModalities {
        val loanModalities = LoanModalities.personalLoan()
        if (age < 30 && location.equals("SÃO PAULO", ignoreCase = true)) {
            loanModalities.addLoan(Modality.GUARANTEE)
        }
        return loanModalities
    }

    override fun validateUse(income: BigDecimal): Boolean {
        return income < BigDecimal("3000")
    }
}