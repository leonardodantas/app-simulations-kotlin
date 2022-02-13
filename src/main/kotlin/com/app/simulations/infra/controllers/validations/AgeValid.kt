package com.app.simulations.infra.controllers.validations

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [AgeValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class AgeValid(
    val message: String = "Cliente precisa ter no minimo 18 anos",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

