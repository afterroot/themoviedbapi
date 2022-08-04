/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import info.movito.themoviedbapi.model.core.AbstractJsonMapping;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;


public class FindResults extends AbstractJsonMapping {

    @JsonProperty("movie_results")
    private List<NetworkMovie> movieResults;

    @JsonProperty("person_results")
    private List<Person> personResults;

    @JsonProperty("tv_results")
    private List<TvSeries> tvResults;


    public List<NetworkMovie> getMovieResults() {
        return movieResults;
    }


    public List<Person> getPersonResults() {
        return personResults;
    }


    public List<TvSeries> getTvResults() {
        return tvResults;
    }


    public void setMovieResults(List<NetworkMovie> movieResults) {
        this.movieResults = movieResults;
    }


    public void setPersonResults(List<Person> personResults) {
        this.personResults = personResults;
    }


    public void setTvResults(List<TvSeries> tvResults) {
        this.tvResults = tvResults;
    }
}
