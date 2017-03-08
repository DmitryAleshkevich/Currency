package com.dmitryaleshkevich

import org.mockito.BDDMockito.*
import com.dmitryaleshkevich.controllers.CurrencyController
import com.dmitryaleshkevich.model.Currency
import com.dmitryaleshkevich.service.CurrencyService
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by dimon on 3/8/17.
 */

@WebMvcTest(CurrencyController::class)
@RunWith(SpringRunner::class)
class CurrencyControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: CurrencyService

    @Test
    fun testController() {
        given(service.getCurrency("USD")).willReturn(Currency("USD"));
        mockMvc.perform(get("/USD").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", CoreMatchers.equalTo("USD")))
    }

}