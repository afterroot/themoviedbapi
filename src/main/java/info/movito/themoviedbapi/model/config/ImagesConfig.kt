/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.config

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping

data class ImagesConfig(
    @JsonProperty("base_url") var baseUrl: String,
    @JsonProperty("secure_base_url") var secureBaseUrl: String,
    @JsonProperty("poster_sizes") var posterSizes: List<String>,
    @JsonProperty("backdrop_sizes") var backdropSizes: List<String>,
    @JsonProperty("profile_sizes") var profileSizes: List<String>,
    @JsonProperty("logo_sizes") var logoSizes: List<String>,
    @JsonProperty("still_sizes") var stillSizes: List<String>,
) : AbstractJsonMapping() {

    /**
     * Check that the poster size is valid
     *
     * @param posterSize
     */
    fun isValidPosterSize(
        posterSize: String,
    ): Boolean = if (posterSize.isBlank() || posterSizes.isEmpty()) {
        false
    } else {
        posterSizes.contains(posterSize)
    }

    /**
     * Check that the backdrop size is valid
     *
     * @param backdropSize
     */
    fun isValidBackdropSize(
        backdropSize: String,
    ): Boolean = if (backdropSize.isBlank() || backdropSizes.isEmpty()) {
        false
    } else {
        backdropSizes.contains(backdropSize)
    }

    /**
     * Check that the profile size is valid
     *
     * @param profileSize
     */
    fun isValidProfileSize(
        profileSize: String,
    ): Boolean = if (profileSize.isBlank() || profileSizes.isEmpty()) {
        false
    } else {
        profileSizes.contains(profileSize)
    }

    /**
     * Check that the logo size is valid
     *
     * @param logoSize
     */
    fun isValidLogoSize(
        logoSize: String,
    ): Boolean = if (logoSize.isBlank() || logoSizes.isEmpty()) {
        false
    } else {
        logoSizes.contains(logoSize)
    }

    /**
     * Check to see if the size is valid for any of the images types
     *
     * @param sizeToCheck
     */
    fun isValidSize(sizeToCheck: String): Boolean = isValidPosterSize(sizeToCheck) ||
        isValidBackdropSize(sizeToCheck) ||
        isValidProfileSize(sizeToCheck) ||
        isValidLogoSize(sizeToCheck)
}
