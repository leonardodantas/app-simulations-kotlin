package com.app.simulations.infra.controllers.response

import com.app.simulations.app.models.ILocation

data class LocationResponse(
    override val cep: String,
    override val logradouro: String,
    override val complemento: String,
    override val bairro: String,
    override val localidade: String,
    override val uf: String,
    override val ibge: String,
    override val gia: String,
    override val ddd: String,
    override val siafi: String
) : ILocation