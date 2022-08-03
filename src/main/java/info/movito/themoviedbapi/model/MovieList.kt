/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.NamedStringIdElement

class MovieList : NamedStringIdElement() {
    @JsonProperty("created_by")
    var createdBy: String? = null

    @JsonProperty("description")
    var description: String? = null

    @JsonProperty("favorite_count")
    var favoriteCount: Int = 0

    @JsonProperty("item_count")
    var itemCount: Int = 0

    @JsonProperty("poster_path")
    var posterPath: String? = null

    @JsonProperty("list_type")
    var listType: String? = null

    // used for /list
    @JsonProperty("items")
    var items: List<NetworkMovie>? = null
}
