/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model.people;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import info.movito.themoviedbapi.model.core.AbstractJsonMapping;


public class PersonCredits extends AbstractJsonMapping {

    @JsonProperty("cast")
    private List<PersonCredit> cast;
    @JsonProperty("crew")
    private List<PersonCredit> crew;


    public List<PersonCredit> getCast() {
        return cast;
    }

    public void setCast(List<PersonCredit> cast) {
        this.cast = cast;
    }

    public List<PersonCredit> getCrew() {
        return crew;
    }

    public void setCrew(List<PersonCredit> crew) {
        this.crew = crew;
    }
}
