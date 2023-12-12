package com.example.demo.router

import com.example.demo.service.DemoService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Service
class DemoHandler(
    private val demoService: DemoService
) {

    private val logger = KotlinLogging.logger {}

    suspend fun demoCall(req: ServerRequest): ServerResponse {
        logger.info { "test handler" }
        return ServerResponse.ok().bodyValueAndAwait(demoService())
    }

}