package com.app.simulations.infra.controllers

import com.app.simulations.app.models.IProposal
import com.app.simulations.app.usecases.IFindProposals
import io.swagger.annotations.Api
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/proposals")
@Api(tags = ["Proposals"])
class FindProposalsController(
    private val findProposals: IFindProposals
) {

    @GetMapping("/customer/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    fun findByCPF(@PathVariable cpf: String, @RequestParam(defaultValue = "0") page: Int,@RequestParam(defaultValue = "20") size: Int): ResponseEntity<Page<IProposal>> {
        val response = findProposals.findAllByCPF(PageRequest.of(page, size), cpf)
        if(response.isEmpty){
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{proposalId}")
    fun findByProposalId(@PathVariable proposalId: String): IProposal {
        return findProposals.findbyProposalId(proposalId)
    }
}