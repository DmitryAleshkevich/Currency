package com.dmitryaleshkevich.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.jackson.JsonComponent

/**
 * Created by dimon on 3/8/17.
 */

@JsonComponent
class CurrencyDTO() {
    @JsonProperty(value = "Cur_Abbreviation")
    var name: String = ""

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as CurrencyDTO

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int{
        return name.hashCode()
    }
}