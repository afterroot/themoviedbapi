/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.core

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.Types

open class ResultsPage<T> : AbstractJsonMapping(), Iterable<T> {
    @JsonProperty("results")
    lateinit var results: MutableList<T>

    @JsonProperty("page")
    var page = 0

    @JsonProperty("total_pages")
    var totalPages = 0

    @JsonProperty("total_results")
    var totalResults = 0

    @JsonIgnore
    override fun iterator(): MutableIterator<T> {
        return results.iterator()
    }

    @JsonIgnore
    fun type(): Int = Types.RESULT_PAGE
}
