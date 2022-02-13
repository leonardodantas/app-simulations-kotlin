package com.app.simulations.domain.impl

import com.app.simulations.app.usecases.IGenerateIOF
import com.app.simulations.domain.DataForSimulation
import com.app.simulations.domain.ISimulateLoan
import com.app.simulations.domain.entities.Installments
import com.app.simulations.domain.entities.Proposal
import com.app.simulations.domain.entities.Simulations
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

@Service
class SimulateLoan(
    private val generateIOF: IGenerateIOF
) : ISimulateLoan {


    override fun simulate(dataForSimulation: DataForSimulation): Proposal {

        val iofFixed = generateIOF.getIOFFixed(dataForSimulation.loanAmount)

        val proposal = Proposal.of(dataForSimulation, iofFixed)

        for (currentSimulation in 1..12) {

            val amount = this.generateValueWithInterest(currentSimulation, proposal)

            val installments = this.genetateInstallments(currentSimulation, amount)

            val iofDaily = generateIOF.getIOFDaily(dataForSimulation.loanAmount, installments.last().dueDate)

            val simulation = Simulations.of(amount, currentSimulation, installments, iofFixed, iofDaily)

            proposal.addSimulation(simulation)
        }

        return proposal
    }

    private fun genetateInstallments(currentSimulation: Int, amount: BigDecimal): MutableList<Installments> {
        val installments: MutableList<Installments> = mutableListOf()
        var dueDate = LocalDate.now()
        for (currentInstallment in 1..currentSimulation) {
            dueDate = dueDate.plusMonths(1)
            val installmentValue = amount.divide(BigDecimal(currentSimulation), 2, RoundingMode.HALF_DOWN).setScale(
                2,
                RoundingMode.HALF_DOWN
            )
            val installment = Installments.from(dueDate, installmentValue)
            installments.add(installment)
        }
        return installments
    }


    private fun generateValueWithInterest(currentSimulation: Int, proposal: Proposal): BigDecimal {
        var installmentValue =
            proposal.loanAmount.divide(BigDecimal(currentSimulation), 2, RoundingMode.HALF_DOWN).setScale(
                2,
                RoundingMode.HALF_DOWN
            )
        var amount = BigDecimal.ZERO
        for (installment in 1..currentSimulation) {
            val interest =
                installmentValue.multiply(BigDecimal(proposal.taxe / 100)).setScale(2, RoundingMode.HALF_DOWN)
            installmentValue += interest
            amount = (amount.plus(installmentValue))
        }
        return amount
    }
}