package com.example.factorial_app

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class FactorialController(
    private val factorialService: FactorialService,
) {
    private val logger: Logger = LoggerFactory.getLogger(FactorialController::class.java)

    @GetMapping("/factorial")
    fun factorial(
        @RequestParam("n") n: Int
    ): BigDecimal {
        if(n < 0) {
            throw IllegalArgumentException("n must be non-negative")
        }

        logger.info("Calculating factorial of $n")

        return factorialService.calculate(n)
    }
}