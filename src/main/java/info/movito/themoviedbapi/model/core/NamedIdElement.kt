/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.core

import com.fasterxml.jackson.annotation.JsonProperty

open class NamedIdElement : IdElement() {
    @JsonProperty("name")
    var name: String? = null

    override fun toString(): String {
        return "$name [$id]"
    }
}
