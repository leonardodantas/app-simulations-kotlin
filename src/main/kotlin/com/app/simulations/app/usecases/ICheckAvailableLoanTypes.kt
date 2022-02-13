package com.app.simulations.app.usecases

import com.app.simulations.app.models.ICustomerConditions
import com.app.simulations.app.models.ILoanModalitiesForCustomer

interface ICheckAvailableLoanTypes {

    fun checkCustomer(customerConditions: ICustomerConditions): ILoanModalitiesForCustomer

}
