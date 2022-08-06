/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.movito.themoviedbapi.model.core.ResponseStatus;


public class MovieListCreationStatus extends ResponseStatus {

    @JsonProperty("list_id")
    private String listId;


    public String getListId() {
        return listId;
    }


    public void setListId(String listId) {
        this.listId = listId;
    }
}
