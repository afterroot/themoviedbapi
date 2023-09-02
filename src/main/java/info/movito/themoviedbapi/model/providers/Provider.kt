/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.providers

import com.fasterxml.jackson.annotation.JsonProperty

data class Provider(
    @JsonProperty("display_priority") var displayPriority: Int? = null,
    @JsonProperty("logo_path") var logoPath: String? = null,
    @JsonProperty("provider_id") var providerId: Int? = null,
    @JsonProperty("provider_name") var providerName: String? = null,
)
