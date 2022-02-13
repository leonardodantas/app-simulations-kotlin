package com.app.simulations.domain.entities

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "iof")
data class IOF(

    @Id
    private val id: String,

    @Column(length = 20, unique = true)
    val type: String,
    val aliquot: BigDecimal,
) {

    constructor(): this("", "", BigDecimal.ZERO)
}