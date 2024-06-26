/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import info.movito.themoviedbapi.model.core.AbstractJsonMapping;


public class ReleaseInfo extends AbstractJsonMapping {


    @JsonProperty("iso_3166_1")
    private String country;
    @JsonProperty("release_dates")
    private List<ReleaseDate> releaseDates;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ReleaseDate> getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(List<ReleaseDate> releaseDates) {
        this.releaseDates = releaseDates;
    }
}
