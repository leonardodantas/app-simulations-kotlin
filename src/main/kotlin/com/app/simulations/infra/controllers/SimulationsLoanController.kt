package com.app.simulations.infra.controllers

import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.usecases.impl.GenerateSimulations
import com.app.simulations.infra.controllers.request.ProposalForSimulationRequest
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/simulations")
@Api(tags = ["Simulations"])
class SimulationsLoanController(private val generateSimulations: GenerateSimulations) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun generateSimulations(@Valid @RequestBody body: ProposalForSimulationRequest): IProposalWithSimulations {
        return this.generateSimulations.generateByProposal(body)
    }
}