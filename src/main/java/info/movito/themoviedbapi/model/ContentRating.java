/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.List;

import info.movito.themoviedbapi.model.core.IdElement;

@JsonRootName("content_ratings")
public class ContentRating implements Serializable {

    @JsonProperty("iso_3166_1")
    private String locale;

    @JsonProperty("rating")
    private String rating;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public static class Results extends IdElement {

        @JsonProperty("results")
        private List<ContentRating> results;

        public List<ContentRating> getContentRatings() {
            return results;
        }

        public void setContentRatings(List<ContentRating> contentRatings) {
            results = contentRatings;
        }
    }
}
