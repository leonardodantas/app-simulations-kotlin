package com.app.simulations.infra.controllers

import com.app.simulations.app.models.ILoanModalitiesForCustomer
import com.app.simulations.app.usecases.ICheckAvailableLoanTypes
import com.app.simulations.infra.controllers.request.CustomerConditionsRequest
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/available-loans")
@Api(tags = ["Loans"])
class AvailableLoansController(
    private val checkAvailableLoanTypes :ICheckAvailableLoanTypes
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAvailableLoans(@Valid @RequestBody body: CustomerConditionsRequest): ILoanModalitiesForCustomer {
        return checkAvailableLoanTypes.checkCustomer(body)
    }
}