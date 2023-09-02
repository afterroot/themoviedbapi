/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.tv

import com.fasterxml.jackson.annotation.JsonProperty

data class TvSeason(
    @JsonProperty("air_date") var airDate: String? = null,
    @JsonProperty("poster_path") var posterPath: String? = null,
    @JsonProperty("season_number") var seasonNumber: Int = 0,
    @JsonProperty("overview") var overview: String? = null,
    @JsonProperty("episodes") var episodes: List<TvEpisode>? = null,
) : AbstractTvElement()
