package com.dmitryaleshkevich.controllers

import com.dmitryaleshkevich.service.CurrencyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by dimon on 3/8/17.
 */

@RestController
class CurrencyController(val service: CurrencyService) {

    @GetMapping("/{name}")
    fun getCurrency(@PathVariable name: String) = service.getCurrency(name)
}