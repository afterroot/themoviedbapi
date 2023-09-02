/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.providers

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

data class WatchProviders(
    @JsonProperty("link") var link: String? = null,
    @JsonProperty("rent") var rentProviders: List<Provider>? = null,
    @JsonProperty("buy") var buyProviders: List<Provider>? = null,
    @JsonProperty("flatrate") var flatrateProviders: List<Provider>? = null,
    @JsonProperty("free") var freeProviders: List<Provider>? = null,
) : AbstractJsonMapping()
