package com.app.simulations.domain.entities

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "simulations")
data class Simulations(

    @Id
    val id: String,

    val amount: BigDecimal,

    val numberInstallments: Int,

    val firstDueDate: LocalDate,

    val iofDaily: BigDecimal,

    @OneToMany(cascade = [CascadeType.ALL])
    val installments: MutableList<Installments>
) {

    constructor() : this("", BigDecimal.ZERO, 0, LocalDate.now(), BigDecimal.ZERO, mutableListOf())

    companion object {
        fun of(
            amount: BigDecimal,
            numberInstallments: Int,
            installments: MutableList<Installments>,
            IOFFixed: BigDecimal,
            IOFDaily: BigDecimal
        ): Simulations {
            return Simulations(
                UUID.randomUUID().toString(),
                amount = amount.plus(IOFFixed).plus(IOFDaily).setScale(2, RoundingMode.HALF_DOWN),
                numberInstallments,
                LocalDate.now().plusMonths(1),
                IOFDaily,
                installments = installments.map { it.fromIOFTotal(IOFFixed, IOFDaily, numberInstallments) }.toMutableList()
            )
        }
    }
}