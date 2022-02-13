package com.app.simulations.app.models

import com.app.simulations.app.exceptions.UnavailableModeException
import com.app.simulations.domain.Modality

interface ILoanModalitiesForCustomer {

    val modalities: MutableList<IAvailableModalities>

    fun addLoan(modality: IAvailableModalities)

    fun findModalyByDescription(description: String): IAvailableModalities  {
        try {
            return modalities.first { it.type.equals(description, ignoreCase = true) }
        } catch (ex: Exception) {
            throw UnavailableModeException("Mode not available to the customer")
        }
    }

    fun compatible(modality: Modality) {
        try {
            modalities.first { it.taxes.equals(modality.getTaxe()) }
        } catch (ex: Exception) {
            throw UnavailableModeException("Modalidade incompativel com o perfil do cliente")
        }
    }

}