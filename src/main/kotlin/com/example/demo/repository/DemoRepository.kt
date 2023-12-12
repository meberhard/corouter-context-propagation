package com.example.demo.repository

import com.example.demo.DemoObject
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import org.springframework.stereotype.Repository

@Repository
class DemoRepository {

    private val logger = KotlinLogging.logger {}

    suspend operator fun invoke(): DemoObject {
        logger.info { "demo repository called" }
        delay(1000)
        throw RuntimeException("test")
    }

}