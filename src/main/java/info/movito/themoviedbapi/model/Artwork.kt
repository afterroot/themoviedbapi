/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

data class Artwork(
    @JsonProperty("iso_639_1")
    var language: String? = null,
    @JsonProperty("file_path")
    var filePath: String? = null,
    @JsonProperty("aspect_ratio")
    var aspectRatio: Float = 0f,
    @JsonProperty("height")
    var height: Int = 0,
    @JsonProperty("width")
    var width: Int = 0,
    @JsonProperty("vote_average")
    var voteAverage: Float = 0f,
    @JsonProperty("vote_count")
    var voteCount: Int = 0,
    @JsonProperty("flag")
    var flag: String? = null,
) : AbstractJsonMapping() {
    var artworkType = ArtworkType.POSTER
}
