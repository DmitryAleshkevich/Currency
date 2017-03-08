package com.dmitryaleshkevich.repositories

import com.dmitryaleshkevich.model.Currency
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dimon on 3/8/17.
 */

interface CurrencyRepository : JpaRepository<Currency,Long> {
    fun findDistinctByName(name: String): Currency?
}