/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.people

import com.fasterxml.jackson.annotation.JsonProperty

class PersonCast : Person() {
    @JsonProperty("character")
    var character: String? = null

    @JsonProperty("order")
    var order = 0
}
