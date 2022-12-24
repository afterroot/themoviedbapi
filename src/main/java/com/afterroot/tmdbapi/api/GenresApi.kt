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

import com.afterroot.tmdbapi.model.Genres
import retrofit2.http.GET

interface GenresApi {
    @GET("3/genre/movie/list")
    suspend fun getMoviesGenres(): Genres

    @GET("3/genre/tv/list")
    suspend fun getTvGenres(): Genres
}