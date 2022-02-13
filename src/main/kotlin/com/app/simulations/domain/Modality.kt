package com.app.simulations.domain

enum class Modality(
    private val description: String
) {
    PERSONAL("Personal") {
        override fun getTaxe(): Double {
            return 4.0
        }
    },GUARANTEE("Guarantee") {
        override fun getTaxe(): Double {
            return 3.0
        }
    }, CONSIGNED("Consigned") {
        override fun getTaxe(): Double {
            return 2.0
        }
    };

    abstract fun getTaxe(): Double
}