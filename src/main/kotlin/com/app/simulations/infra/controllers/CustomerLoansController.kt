package com.app.simulations.infra.controllers

import com.app.simulations.app.models.ICustomerLoanDetails
import com.app.simulations.app.usecases.ICustomerLoans
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loans")
@Api(tags = ["Loans"])
class CustomerLoansController(
    private val customerLoans : ICustomerLoans
) {

    @GetMapping("/customers/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    fun findLoanByCPF(@PathVariable cpf: String): ICustomerLoanDetails{
        return customerLoans.findByCPF(cpf)
    }
}