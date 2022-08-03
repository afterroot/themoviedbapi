/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import info.movito.themoviedbapi.model.core.AbstractJsonMapping;

import java.util.List;


public class MoviesAlternativeTitles extends AbstractJsonMapping {

    @JsonProperty("titles")
    private List<AlternativeTitle> titles;


    public List<AlternativeTitle> getTitles() {
        return titles;
    }


    public void setTitles(List<AlternativeTitle> titles) {
        this.titles = titles;
    }
}
