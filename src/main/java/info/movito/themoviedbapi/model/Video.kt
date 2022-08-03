/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import info.movito.themoviedbapi.model.core.IdElement
import info.movito.themoviedbapi.model.core.NamedStringIdElement

@JsonRootName("video")
data class Video(
    @JsonProperty("site")
    var site: String? = null,
    @JsonProperty("key")
    var key: String? = null,
    @JsonProperty("size")
    var size: Int? = null,
    @JsonProperty("type")
    var type: String? = null
) : NamedStringIdElement() {
    class Results : IdElement() {
        @JsonProperty("results")
        val videos: List<Video>? = null
    }
}
