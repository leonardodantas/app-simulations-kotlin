package com.app.simulations.domain.exceptions

class ProposalWithExpiredTimeException(override val message: String) : Exception(message) {
}