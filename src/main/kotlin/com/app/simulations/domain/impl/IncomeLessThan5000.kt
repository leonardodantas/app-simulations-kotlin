package com.app.simulations.domain.impl

import com.app.simulations.domain.IAvailableLoans
import com.app.simulations.domain.Modality
import com.app.simulations.domain.LoanModalities
import java.math.BigDecimal

class IncomeLessThan5000() : IAvailableLoans {

    override fun available(age: Int, location: String): LoanModalities {
        val loanModalities = LoanModalities.personalAndConsignedLoan()
        if (age < 30) {
            loanModalities.addLoan(Modality.GUARANTEE)
        }
        return loanModalities
    }

    override fun validateUse(income: BigDecimal): Boolean {
        return income.compareTo(BigDecimal("5000")) > -1
    }
}