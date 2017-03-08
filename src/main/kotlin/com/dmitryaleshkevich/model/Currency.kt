package com.dmitryaleshkevich.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by dimon on 3/8/17.
 */

@Entity
data class Currency(val name: String = "",
                    @Id
                    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                    val id: Long = -1) {
}