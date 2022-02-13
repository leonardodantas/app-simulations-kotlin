package com.app.simulations.infra.controllers.exceptions

class CepNotFoundException(override val message: String) : Exception(message) {
}