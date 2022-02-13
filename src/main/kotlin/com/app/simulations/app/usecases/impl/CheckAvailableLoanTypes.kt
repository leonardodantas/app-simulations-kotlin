package com.app.simulations.app.usecases.impl

import com.app.simulations.app.models.ICustomerConditions
import com.app.simulations.app.models.ILoanModalitiesForCustomer
import com.app.simulations.app.models.impl.LoanModalitiesForCustomer
import com.app.simulations.app.usecases.ICheckAvailableLoanTypes
import com.app.simulations.app.usecases.ISearchLocation
import com.app.simulations.domain.GetProfileCustomer
import com.app.simulations.domain.LoanModalities
import org.springframework.stereotype.Service

@Service
class CheckAvailableLoanTypes(
    private val searchLocation: ISearchLocation
) : ICheckAvailableLoanTypes {

    override fun checkCustomer(customerConditions: ICustomerConditions): ILoanModalitiesForCustomer {
        val location = searchLocation.findByCEP(customerConditions.cep)

        val availableLoans = GetProfileCustomer.from(customerConditions.income)
        val available: LoanModalities = availableLoans.available(age = customerConditions.age(), location = location.localidade)

        return LoanModalitiesForCustomer.from(available)
    }
}