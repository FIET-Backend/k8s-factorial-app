package com.example.factorial_app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class FactorialController(
    private val factorialService: FactorialService
) {

    @GetMapping("/factorial")
    fun factorial(
        @RequestParam("n") n: Int
    ): BigDecimal {
        if(n < 0) {
            throw IllegalArgumentException("n must be non-negative")
        }
        return factorialService.calculate(n)
    }
}