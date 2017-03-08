package com.dmitryaleshkevich

import com.dmitryaleshkevich.dto.CurrencyDTO
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

/**
 * Created by dimon on 3/8/17.
 */

@RestClientTest
@RunWith(SpringRunner::class)
class CurrencyProviderTest {

    val restTemplate: RestTemplate = RestTemplate()
    val url: String = "http://www.nbrb.by/API/ExRates/Currencies"

    @Test
    fun testProvider() {
        val dtoArray = restTemplate.getForObject(url,Array<CurrencyDTO>::class.java)
        Assertions.assertThat(dtoArray.find { "USD".equals(it.name) }).isNotNull();
        Assertions.assertThat(dtoArray.find { "DUS".equals(it.name) }).isNull();
    }

}