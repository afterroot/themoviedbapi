package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

data class AlternativeTitle(
    @JsonProperty("iso_3166_1")
    var country: String? = null,
    @JsonProperty("title")
    var title: String? = null
) : AbstractJsonMapping()
