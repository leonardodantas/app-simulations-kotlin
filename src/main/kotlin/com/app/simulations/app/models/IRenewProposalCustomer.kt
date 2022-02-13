package com.app.simulations.app.models

import java.math.BigDecimal
import java.time.LocalDate

interface IRenewProposalCustomer {

    val proposalId: String
    val cpf: String
    val income: BigDecimal
    val cep: String
    val birthDate: LocalDate

}
