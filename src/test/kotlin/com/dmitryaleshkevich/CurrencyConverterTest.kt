package com.dmitryaleshkevich

import com.dmitryaleshkevich.dto.CurrencyDTO
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by dimon on 3/8/17.
 */

@JsonTest
@RunWith(SpringRunner::class)
class CurrencyConverterTest {

    @Autowired
    lateinit var json: JacksonTester<CurrencyDTO>

    val dto = CurrencyDTO()

    @Before
    fun init() {
        dto.name = "USD"
    }

    @Test
    fun testSerialize() {
        val content = json.write(dto)
        Assertions.assertThat(content).hasJsonPathValue("@.Cur_Abbreviation")
        Assertions.assertThat(content).extractingJsonPathStringValue("@.Cur_Abbreviation")
                .isEqualTo("USD");
    }

    @Test
    fun testDeserialize() {
        val content = "{\"Cur_Abbreviation\":\"USD\"}";
        Assertions.assertThat(json.parse(content)).isEqualTo(dto);
    }
}