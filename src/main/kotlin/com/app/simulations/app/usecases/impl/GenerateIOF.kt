package com.app.simulations.app.usecases.impl

import com.app.simulations.app.usecases.IGenerateIOF
import com.app.simulations.domain.IOF
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Service
class GenerateIOF : IGenerateIOF {

    override fun getIOFFixed(loanAmount: BigDecimal): BigDecimal {
        return loanAmount
            .multiply(
                IOF.FIXED.rate()
                    .divide(BigDecimal(100))
            )
    }

    override fun getIOFDaily(loanAmount: BigDecimal, lastDueDate: LocalDate): BigDecimal {
        val days = LocalDate.now().until(lastDueDate, ChronoUnit.DAYS)
        return BigDecimal(days).multiply(IOF.DAILY.rate()).divide(BigDecimal(100)).multiply(loanAmount)
    }


}