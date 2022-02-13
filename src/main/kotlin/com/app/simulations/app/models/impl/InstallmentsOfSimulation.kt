package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IInstallments
import com.app.simulations.domain.entities.Installments
import java.math.BigDecimal
import java.time.LocalDate

class InstallmentsOfSimulation(
    override val id: String,
    override val dueDate: LocalDate,
    override val installmentValue: BigDecimal
) : IInstallments {

    companion object {
        fun from(installments: Installments): InstallmentsOfSimulation {
            return InstallmentsOfSimulation(
                installments.id,
                installments.dueDate,
                installments.installmentValue
            )
        }
    }
}