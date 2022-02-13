package com.app.simulations.infra.controllers.advice

import com.app.simulations.app.exceptions.*
import com.app.simulations.domain.exceptions.ProposalWithExpiredTimeException
import com.app.simulations.infra.controllers.advice.response.ErrorResponse
import com.app.simulations.infra.controllers.exceptions.CepNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)

    }

    @ExceptionHandler(UnavailableModeException::class)
    fun unavailableModelExceptionHandler(ex: UnavailableModeException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)

    }

    @ExceptionHandler(SaveEntityException::class)
    fun saveEntityExceptionHandler(ex: SaveEntityException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)

    }

    @ExceptionHandler(ProposalWithExpiredTimeException::class)
    fun proposalWithExpiredTimeExceptionExceptionHandler(ex: ProposalWithExpiredTimeException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)

    }

    @ExceptionHandler(ProposalNotFoundException::class)
    fun proposalNotFoundExceptionExceptionHandler(ex: ProposalNotFoundException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

    @ExceptionHandler(ClientDoesNotHaveLoan::class)
    fun clientDoesNotHaveLoanExceptionHandler(ex: ClientDoesNotHaveLoan): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

    @ExceptionHandler(CepNotFoundException::class)
    fun CepNotFoundExceptionHandler(ex: CepNotFoundException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

    @ExceptionHandler(CustomerAlreadyHasLoanException::class)
    fun customerAlreadyHasLoanExceptionHandler(ex: CustomerAlreadyHasLoanException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)

    }


    @ExceptionHandler(
        SimilarProposalException
        ::class
    )
    fun customerAlreadyHasLoanExceptionHandler(
        ex: SimilarProposalException
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse.from(ex)
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)

    }

}