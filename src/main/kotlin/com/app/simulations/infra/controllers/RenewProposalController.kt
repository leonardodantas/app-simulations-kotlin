package com.app.simulations.infra.controllers

import com.app.simulations.app.usecases.IRenewProposal
import com.app.simulations.infra.controllers.request.RenewProposalRequest
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/renew-proposal")
@Api(tags = ["Renew Proposal"])
class RenewProposalController(
    private val renewProposal: IRenewProposal
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun renewProposal(@Valid @RequestBody body: RenewProposalRequest) {
        renewProposal.renew(body)
    }
}