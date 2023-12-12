package com.example.demo.router

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(Exception::class)
    suspend fun handleException(e: Exception): String {
        logger.info { "Exception handled: ${e.message}" }
        return "Exception handled: ${e.message}"
    }

}