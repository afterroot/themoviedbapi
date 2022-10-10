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

package com.afterroot.tmdbapi.model.config

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

@Entity(tableName = Country.TABLE_NAME)
data class Country(
    @JsonProperty("iso_3166_1")
    @PrimaryKey
    val iso: String,
    @JsonProperty("english_name")
    val englishName: String,
    @JsonProperty("native_name")
    val nativeName: String
) : AbstractJsonMapping() {
    companion object {
        const val TABLE_NAME = "countries"
    }
}
