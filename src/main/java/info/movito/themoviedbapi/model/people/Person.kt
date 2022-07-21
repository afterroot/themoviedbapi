package info.movito.themoviedbapi.model.people

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.NamedIdElement

open class Person : NamedIdElement() {
    @JsonProperty("cast_id")
    var castId = 0

    @JsonProperty("credit_id")
    var creditId: String? = null

    @JsonProperty("profile_path")
    open var profilePath: String? = ""

    @JsonProperty("adult")
    var isAdult = false

    @JsonProperty("gender")
    var gender = false

    @JsonProperty("known_for_department")
    var knownForDepartment: String? = null

    @JsonProperty("original_name")
    var originalName: String? = null

    @JsonProperty("popularity")
    var popularity = 0.0f
}
