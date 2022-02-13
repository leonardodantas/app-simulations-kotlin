package com.app.simulations.infra.rest

import com.app.simulations.app.usecases.ISearchLocation
import com.app.simulations.infra.controllers.exceptions.CepNotFoundException
import com.app.simulations.infra.controllers.response.LocationResponse
import org.springframework.stereotype.Component

@Component
class SearchLocation(
    private val viaCEPClient: ViaCEPClient
) : ISearchLocation {


    override fun findByCEP(cep: String): LocationResponse {
        val location = viaCEPClient.findByCep(cep)
        if(location.localidade.isNullOrEmpty()) {
            throw CepNotFoundException("Cep $cep não encontrado")
        }
        return location
    }
}