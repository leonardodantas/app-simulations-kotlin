package com.app.simulations.infra.controllers.validations

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [CEPValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class CEPValid(
    val message: String = "O CEP precisa estar em um formato valido [00000000]",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
