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
package com.afterroot.tmdbapi.api

import info.movito.themoviedbapi.TmdbPeople
import info.movito.themoviedbapi.model.core.MovieResultsPage
import info.movito.themoviedbapi.model.core.TvResultsPage
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SearchApi {
    @GET("3/search/tv")
    suspend fun searchTv(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): TvResultsPage

    @GET("3/search/tv")
    suspend fun searchTv(@QueryMap params: Map<String, String>): TvResultsPage

    @GET("3/search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): MovieResultsPage

    @GET("3/search/movie")
    suspend fun searchMovie(@QueryMap params: Map<String, String>): MovieResultsPage

    @GET("3/search/person")
    suspend fun searchPerson(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): TmdbPeople.PersonResultsPage

    @GET("3/search/person")
    suspend fun searchPerson(@QueryMap params: Map<String, String>): TmdbPeople.PersonResultsPage
}
