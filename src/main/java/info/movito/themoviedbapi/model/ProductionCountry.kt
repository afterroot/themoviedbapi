/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

@JsonRootName("production_country")
data class ProductionCountry(
    @JsonProperty("iso_3166_1")
    var isoCode: String? = null,
    @JsonProperty("name")
    var name: String? = null
) : AbstractJsonMapping()
