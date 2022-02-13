package com.app.simulations.infra.rest

import com.app.simulations.infra.controllers.response.LocationResponse
import feign.Param
import feign.RequestLine

interface ViaCEPClient {

    @RequestLine("GET /{cep}/json/")
    fun findByCep(@Param("cep") cep: String): LocationResponse
}