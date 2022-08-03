/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.IdElement

class MovieImages : IdElement() {
    @JsonProperty("backdrops")
    var backdrops: List<Artwork>? = null

    @JsonProperty("posters")
    var posters: List<Artwork>? = null

    @JsonProperty("profiles")
    var profiles: List<Artwork>? = null

    // needed for episode backdrops
    @JsonProperty("stills")
    var stills: List<Artwork>? = null

    /**
     * Convenience wrapper to return a list of all the artwork with their types.
     */
    fun getAll(vararg artworkTypes: ArtworkType?): List<Artwork> {
        val artwork: MutableList<Artwork> = ArrayList()
        val types: List<ArtworkType?> = listOf(*if (artworkTypes.isNotEmpty()) artworkTypes else ArtworkType.values())

        // Add all the posters to the list
        if (types.contains(ArtworkType.POSTER) && posters != null) {
            updateArtworkType(posters!!, ArtworkType.POSTER)
            artwork.addAll(posters!!)
        }

        // Add all the backdrops to the list
        if (types.contains(ArtworkType.BACKDROP) && backdrops != null) {
            updateArtworkType(backdrops!!, ArtworkType.BACKDROP)
            artwork.addAll(backdrops!!)
        }

        // Add all the backdrops to the list
        if (types.contains(ArtworkType.PROFILE) && profiles != null) {
            updateArtworkType(profiles!!, ArtworkType.PROFILE)
            artwork.addAll(profiles!!)
        }
        return artwork
    }

    /**
     * Update the artwork type for the artwork list
     */
    private fun updateArtworkType(artworkList: List<Artwork>, type: ArtworkType) {
        for (artwork in artworkList) {
            artwork.artworkType = type
        }
    }
}
