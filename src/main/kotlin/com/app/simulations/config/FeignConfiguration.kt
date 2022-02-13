package com.app.simulations.config

import com.app.simulations.infra.rest.ViaCEPClient
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.slf4j.Slf4jLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration (
) {

    @Bean
    fun configViaCEP(): ViaCEPClient {
        return Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .logger(Slf4jLogger(ViaCEPClient::class.java))
            .target(ViaCEPClient::class.java, "https://viacep.com.br/ws/")
    }
}