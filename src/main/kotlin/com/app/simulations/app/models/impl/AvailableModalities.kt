package com.app.simulations.app.models.impl

import com.app.simulations.app.models.IAvailableModalities
import com.app.simulations.domain.Modality

class AvailableModalities(override val type: String, override val taxes: Double) : IAvailableModalities {

    companion object {
        fun from(modality: Modality): AvailableModalities {
            return AvailableModalities(
                type = modality.name,
                taxes = modality.getTaxe()
            )
        }
    }
}