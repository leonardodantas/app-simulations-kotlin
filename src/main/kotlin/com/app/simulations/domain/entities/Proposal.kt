package com.app.simulations.domain.entities

import com.app.simulations.domain.DataForSimulation
import com.app.simulations.domain.Modality
import com.app.simulations.domain.exceptions.ProposalWithExpiredTimeException
import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "proposals")
data class Proposal(

    @Id
    val id: String,

    @Column(length = 15)
    val cpf: String,

    @Enumerated(EnumType.STRING)
    val modality: Modality,
    val taxe: Double,
    val loanAmount: BigDecimal,
    val simulationDate: LocalDateTime,

    @OneToMany(cascade = [CascadeType.ALL])
    val simulations: MutableList<Simulations>,

    val iofFixed: BigDecimal
) {

    constructor() : this("", "", Modality.PERSONAL, 4.0, BigDecimal.ZERO, LocalDateTime.now(), mutableListOf(), BigDecimal.ZERO)

    companion object {
        fun of(dataForSimulation: DataForSimulation, iofFixed: BigDecimal): Proposal {
            return Proposal(
                UUID.randomUUID().toString(),
                dataForSimulation.cpf,
                dataForSimulation.modality,
                dataForSimulation.modality.getTaxe(), dataForSimulation.loanAmount,
                LocalDateTime.now(),
                mutableListOf(),
                iofFixed
            )
        }
    }

    fun addSimulation(simulation: Simulations) {
        this.simulations.add(simulation)
    }

    fun isWithinTheDeadline() {
        if (!this.isValid()) {
            throw ProposalWithExpiredTimeException("Proposa [${id}] excedeu o tempo de 30 minutos de duração")
        }
    }

    fun isValid(): Boolean {
        return Duration.between(simulationDate, LocalDateTime.now()).toMinutes() < 30
    }

    fun isWithinTheRenewalPeriod() {
        if (Duration.between(simulationDate, LocalDateTime.now()).toDays() > 30 || !this.isValid()
        ) {
            throw ProposalWithExpiredTimeException(
                "A Proposa [${id}] precisa ter mais de 30 minutos e menos de 30 dias para ser renovavel"
            )
        }
    }

    fun renew(): Proposal {
        return Proposal(
            id,
            cpf,
            modality,
            modality.getTaxe(), loanAmount,
            LocalDateTime.now().plusMonths(1),
            simulations,
            iofFixed
        )
    }
}