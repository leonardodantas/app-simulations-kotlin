package com.app.simulations.infra.controllers.validations

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [CPFHasLoanValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class CPFHasLoanValid(
    val message: String = "O CPF já possui um emprestimo em andamento",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
