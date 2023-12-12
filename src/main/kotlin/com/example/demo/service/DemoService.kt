package com.example.demo.service

import com.example.demo.DemoObject
import com.example.demo.repository.DemoRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class DemoService(
    private val demoRepository: DemoRepository
) {

    private val logger = KotlinLogging.logger {}

    suspend operator fun invoke() : DemoObject {
        logger.info { "call to test service" }
        return demoRepository()
    }

}