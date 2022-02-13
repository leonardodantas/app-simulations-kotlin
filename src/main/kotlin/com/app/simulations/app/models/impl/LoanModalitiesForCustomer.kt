package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IAvailableModalities
import com.app.simulations.app.models.ILoanModalitiesForCustomer
import com.app.simulations.domain.LoanModalities

class LoanModalitiesForCustomer(override val modalities: MutableList<IAvailableModalities>) :
    ILoanModalitiesForCustomer {

    companion object {
        fun from(loanModalities: LoanModalities): LoanModalitiesForCustomer {
            return LoanModalitiesForCustomer(
                modalities = loanModalities.modalities.map { AvailableModalities.from(it) }.toMutableList()
            )
        }
    }

    override fun addLoan(modality: IAvailableModalities) {
        this.modalities.add(modality)
    }
}