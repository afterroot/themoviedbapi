/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.people

import com.fasterxml.jackson.annotation.JsonProperty

class PersonCrew : Person() {
    @JsonProperty("department")
    var department: String? = null

    @JsonProperty("job")
    var job: String? = null
}
