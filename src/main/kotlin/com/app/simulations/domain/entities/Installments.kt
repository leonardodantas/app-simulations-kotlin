package com.app.simulations.domain.entities

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "installments")
data class Installments(

    @Id
    val id: String,
    val dueDate: LocalDate,
    val installmentValue: BigDecimal
) {

    fun fromIOFTotal(IOFTotal: BigDecimal, IOFDaily: BigDecimal, numberInstallments: Int): Installments {
        return Installments(
            id,
            dueDate,
            installmentValue = installmentValue.plus(
                IOFTotal.divide(
                    BigDecimal(numberInstallments),
                    2,
                    RoundingMode.HALF_DOWN
                )
            ).plus(
                IOFDaily.divide(
                    BigDecimal(numberInstallments),
                    2,
                    RoundingMode.HALF_DOWN
                )
            ).setScale(2)
        )
    }

    companion object {
        fun from(dueDate: LocalDate, installmentValue: BigDecimal): Installments {
            return Installments(
                UUID.randomUUID().toString(),
                dueDate,
                installmentValue
            )
        }
    }
}