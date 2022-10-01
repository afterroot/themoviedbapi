/*
 * Copyright (C) 2020-2022 AfterROOT
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afterroot.tmdbapi.repository

import com.afterroot.tmdbapi.api.TVApi
import com.afterroot.tmdbapi.model.MovieAppendableResponses
import info.movito.themoviedbapi.model.Credits
import info.movito.themoviedbapi.model.tv.TvSeries

class TVRepository(val api: TVApi) {
    suspend fun getTVInfo(id: Int) = api.getTVInfo(id)

    suspend fun getFullTvInfo(id: Int, vararg appendableResponses: MovieAppendableResponses): TvSeries {
        val joined = appendableResponses.joinToString(",")
        return api.getFullTvInfo(id, joined)
    }

    suspend fun getCredits(id: Int): Credits = api.getCredits(id)

    suspend fun getSimilar(id: Int) = api.getSimilar(id)

    suspend fun getRecommended(id: Int) = api.getRecommended(id)

    suspend fun getSeason(id: Int, season: Int) = api.getSeason(id, season)
}
