package com.app.simulations.infra.controllers

import com.app.simulations.app.models.IProposalWithSimulations
import com.app.simulations.app.usecases.IFindProposalsAndDetails
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proposals")
@Api(tags = ["Proposals"])
class FindProposalsAndDetailsController(
    private val findProposalsAndDetails: IFindProposalsAndDetails
) {

    @GetMapping("/{proposalId}/details")
    @ResponseStatus(HttpStatus.OK)
    fun findByProposalId(@PathVariable proposalId: String): IProposalWithSimulations {
        return findProposalsAndDetails.findByProposalId(proposalId)
    }
}