package com.app.simulations.domain

import com.app.simulations.domain.entities.Proposal

interface ISimulateLoan {

    fun simulate(dataForSimulation: DataForSimulation): Proposal
}