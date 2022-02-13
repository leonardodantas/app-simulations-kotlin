package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IInstallments
import com.app.simulations.app.models.ISimulations
import com.app.simulations.domain.entities.Simulations
import java.math.BigDecimal
import java.time.LocalDate

class SimulationsOfProposal(
    override val id: String,
    override val amount: BigDecimal,
    override val numberInstallments: Int,
    override val firstDueDate: LocalDate,
    override val iofDaily: BigDecimal,
    override val installments: MutableList<IInstallments>
) : ISimulations {

    companion object {
        fun from(simulations: Simulations): SimulationsOfProposal {
            return SimulationsOfProposal(
                simulations.id,
                simulations.amount,
                simulations.numberInstallments,
                simulations.firstDueDate,
                simulations.iofDaily,
                simulations.installments.map { InstallmentsOfSimulation.from(it) }.toMutableList()
            )
        }
    }
}