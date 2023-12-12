package com.example.demo.router

import com.example.demo.DemoObject
import com.example.demo.service.DemoService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(
    private val demoService: DemoService
) {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/test")
    suspend fun test(): DemoObject {
        logger.info { "test contoller called" }
        return demoService()
    }

}