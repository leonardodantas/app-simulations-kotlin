package com.app.simulations.domain

class LoanModalities(
    val modalities: MutableList<Modality>
) {
    companion object {
        fun personalLoan(): LoanModalities {
            return LoanModalities(
                mutableListOf(Modality.PERSONAL)
            )
        }

        fun personalAndConsignedLoan(): LoanModalities {
            return LoanModalities(
                mutableListOf(
                    Modality.PERSONAL, Modality.CONSIGNED
                )
            )
        }
    }

    fun addLoan(modality: Modality) {
        modalities.add(modality)
    }

}