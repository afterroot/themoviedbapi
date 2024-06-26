/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import info.movito.themoviedbapi.model.core.IdElement
import org.apache.commons.lang3.StringUtils

@JsonRootName("collection")
data class Collection(
    @JsonProperty("title")
    private var title: String? = null,
    @JsonProperty("name")
    private var name: String? = null,
    @JsonProperty("poster_path")
    var posterPath: String? = null,
    @JsonProperty("backdrop_path")
    var backdropPath: String? = null,
    @JsonProperty("release_date")
    var releaseDate: String? = null,
) : IdElement() {

    fun getTitle(): String? {
        return if (StringUtils.isBlank(title)) {
            name
        } else {
            title
        }
    }

    fun getName(): String? {
        return if (StringUtils.isBlank(name)) {
            title
        } else {
            name
        }
    }
}
