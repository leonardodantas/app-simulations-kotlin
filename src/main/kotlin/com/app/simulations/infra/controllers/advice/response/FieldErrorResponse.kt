package com.app.simulations.infra.controllers.advice.response

import org.springframework.validation.FieldError

data class FieldErrorResponse(
    val message: String,
    val field: String
) {
    companion object {
        fun from(fieldError: FieldError): FieldErrorResponse {
            return FieldErrorResponse(fieldError.defaultMessage ?: "invalid", fieldError.field)
        }
    }
}
