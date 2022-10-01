/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */
package info.movito.themoviedbapi.model.tv

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.Credits
import info.movito.themoviedbapi.model.ExternalIds
import info.movito.themoviedbapi.model.MovieImages
import info.movito.themoviedbapi.model.Video
import info.movito.themoviedbapi.model.core.NamedIdElement
import info.movito.themoviedbapi.model.core.TvKeywords
import info.movito.themoviedbapi.model.keywords.Keyword

open class AbstractTvElement : NamedIdElement() {
    // Appendable responses for all tv elements
    @JsonProperty("credits")
    var credits: Credits? = null

    @JsonProperty("external_ids")
    var externalIds: ExternalIds? = null

    @JsonProperty("images")
    var images: MovieImages? = null

    @JsonProperty("videos")
    private var videos: Video.Results? = null

    @JsonProperty("keywords")
    private var keywords: TvKeywords? = null

    fun getVideos(): List<Video>? {
        return if (videos != null) videos!!.videos else null
    }

    fun setVideos(videos: Video.Results?) {
        this.videos = videos
    }

    fun getKeywords(): List<Keyword>? {
        return if (keywords != null) {
            keywords?.keywords
        } else {
            emptyList()
        }
    }

    fun setKeywords(keywords: TvKeywords?) {
        this.keywords = keywords
    }
}
