/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.providers

import com.fasterxml.jackson.annotation.JsonProperty

data class ProviderResults(
    @JsonProperty("id") val id: Int = 0,
    @JsonProperty("results") var results: Map<String, WatchProviders?>? = null,
) {
    fun getProvidersForCountry(country: String): WatchProviders? {
        return results?.getOrDefault(country, null)
    }

    companion object {
        val EMPTY = ProviderResults()
    }
}
