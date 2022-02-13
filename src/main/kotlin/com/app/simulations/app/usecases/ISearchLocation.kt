package com.app.simulations.app.usecases

import com.app.simulations.app.models.ILocation

interface ISearchLocation {

    fun findByCEP(cep: String): ILocation
}