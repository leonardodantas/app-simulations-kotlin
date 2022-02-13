package com.app.simulations.infra.controllers

import com.app.simulations.app.usecases.IAcceptProposal
import com.app.simulations.infra.controllers.request.AcceptProposalRequest
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/accept-proposal")
@Api(tags = ["Proposals"])
class AcceptProposalController(
    private val acceptProposal: IAcceptProposal
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun accept(@Valid @RequestBody body: AcceptProposalRequest){
        acceptProposal.accept(body)
    }
}