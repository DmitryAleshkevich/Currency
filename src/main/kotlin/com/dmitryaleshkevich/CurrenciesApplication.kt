package com.dmitryaleshkevich

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class CurrenciesApplication

fun main(args: Array<String>) {
    SpringApplication.run(CurrenciesApplication::class.java, *args)
}
