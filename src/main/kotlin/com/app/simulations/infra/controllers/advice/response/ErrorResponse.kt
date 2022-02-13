package com.app.simulations.infra.controllers.advice.response

import com.app.simulations.app.exceptions.*
import com.app.simulations.domain.exceptions.ProposalWithExpiredTimeException
import com.app.simulations.infra.controllers.exceptions.CepNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import java.util.*

data class ErrorResponse(
    val httpCode: Int,
    val uuid: String,
    val message: String,
    var errors: List<FieldErrorResponse>?
) {

    companion object {

        fun from(exception: MethodArgumentNotValidException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                UUID.randomUUID().toString(),
                "INVALID REQUEST",
                exception.bindingResult.fieldErrors.map { FieldErrorResponse.from(it) })
        }

        fun from(exception: UnavailableModeException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(exception: SaveEntityException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }


        fun from(exception: ProposalWithExpiredTimeException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(exception: ProposalNotFoundException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(
            exception: ClientDoesNotHaveLoan
        ): ErrorResponse {
            return ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(exception: CustomerAlreadyHasLoanException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(exception: SimilarProposalException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }

        fun from(exception: CepNotFoundException): ErrorResponse {
            return ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                UUID.randomUUID().toString(),
                exception.message,
                null
            )
        }
    }

}

