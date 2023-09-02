/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.tv

import com.fasterxml.jackson.annotation.JsonProperty

data class TvEpisode(
    @JsonProperty("air_date") var airDate: String? = null,
    @JsonProperty("episode_number") var episodeNumber: Int = 0,
    @JsonProperty("overview") var overview: String? = null,
    @JsonProperty("rating") var userRating: Float = 0f,
    @JsonProperty("season_number") var seasonNumber: Int? = null,
    @JsonProperty("show_id") var seriesId: Int = 0,
    @JsonProperty("still_path") var stillPath: String? = null,
    @JsonProperty("vote_average") var voteAverage: Float = 0f,
    @JsonProperty("vote_count") var voteCount: Int = 0,
) : AbstractTvElement()
