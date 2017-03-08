package com.dmitryaleshkevich

import com.dmitryaleshkevich.model.Currency
import com.dmitryaleshkevich.repositories.CurrencyRepository
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by dimon on 3/8/17.
 */

@DataJpaTest
@RunWith(SpringRunner::class)
open class CurrencyJpaTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var currencyRepository: CurrencyRepository

    @Test
    fun testFind() {
        entityManager.persist(Currency("USD"))
        Assertions.assertThat(currencyRepository.findDistinctByName("USD")?.name).isEqualTo("USD");
        Assertions.assertThat(currencyRepository.findDistinctByName("EUR")).isNull();
    }
}