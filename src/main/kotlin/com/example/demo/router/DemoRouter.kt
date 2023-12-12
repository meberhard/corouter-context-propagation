package com.example.demo.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class DemoRouter(
    private val demoHandler: DemoHandler,
    private val errorHandler: ErrorHandler
) {

    @Bean
    fun demoRoutes() = coRouter {
        "/rest".nest {
            "v1".nest {
                "/demo".nest {
                    GET("", demoHandler::demoCall)
                }
            }
        }
        onError<RuntimeException> { throwable, serverRequest ->
            errorHandler.handleError(throwable, serverRequest)
        }
    }

}