package com.app.simulations.domain.entities

import com.app.simulations.domain.Modality
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "customers_loan")
data class CustomerLoan(

    @Id
    val id: String,
    @Column(unique = true, length = 15)
    val cpf: String,
    @OneToOne(cascade = [CascadeType.ALL])
    val simulation: Simulations,
    @Enumerated(EnumType.STRING)
    val modality: Modality,
    val taxe: Double,
    val loanAmount: BigDecimal,
    val simulationDate: LocalDateTime,
    val acceptanceDate: LocalDateTime
) {
    companion object {
        fun of(proposal: Proposal, simulationId: String): CustomerLoan {
            return CustomerLoan(
                UUID.randomUUID().toString(),
                proposal.cpf,
                proposal.simulations.first{ it.id == simulationId },
                proposal.modality,
                proposal.taxe,
                proposal.loanAmount,
                proposal.simulationDate,
                LocalDateTime.now()
            )
        }
    }
}