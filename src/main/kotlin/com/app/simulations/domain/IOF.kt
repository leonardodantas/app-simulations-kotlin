package com.app.simulations.domain

import java.math.BigDecimal

enum class IOF {

    DAILY {
        override fun rate(): BigDecimal {
            return BigDecimal("0.0082")
        }
    }, FIXED {
        override fun rate(): BigDecimal {
            return BigDecimal("0.38")
        }
    };

    abstract fun  rate(): BigDecimal
}