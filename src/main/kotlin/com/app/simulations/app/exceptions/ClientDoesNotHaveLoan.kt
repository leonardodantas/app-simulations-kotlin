package com.app.simulations.app.exceptions

class ClientDoesNotHaveLoan(
    override val message: String
) : Exception(message) {
}