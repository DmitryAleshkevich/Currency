package com.dmitryaleshkevich.service

import com.dmitryaleshkevich.dto.CurrencyDTO
import com.dmitryaleshkevich.model.Currency
import com.dmitryaleshkevich.repositories.CurrencyRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * Created by dimon on 3/8/17.
 */
@Service
class CurrencyService(val repository: CurrencyRepository,
                           val url: String = "http://www.nbrb.by/API/ExRates/Currencies",
                           val restTemplate: RestTemplate = RestTemplate()) {

    fun getCurrency(name: String): Currency? {
        val persisted = repository.findDistinctByName(name)
        if (persisted != null) return persisted

        val dtoArray = restTemplate.getForObject(url,Array<CurrencyDTO>::class.java)
        val neededDto = dtoArray.find { name.equals(it.name) }
        if (neededDto != null) {
            val founded = Currency(neededDto.name)
            repository.save(founded)
            return founded
        }

        return null;
    }
}