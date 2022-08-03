/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.config

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.AbstractJsonMapping
import java.io.Serializable

class ConfigResults : AbstractJsonMapping(), Serializable {
    @JsonProperty("images")
    var imagesConfig: ImagesConfig? = null

    @JsonProperty("change_keys")
    var changeKeys: List<String>? = null
}
