package com.app.simulations.infra.controllers.request

import com.app.simulations.app.models.IModality

enum class ModalityRequest(private val description: String) : IModality {

    PERSONAL("Personal"), GUARANTEE("Guarantee"), CONSIGNED("Consigned");

    override fun getDescription(): String {
        return description
    }
}