/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi;

import static info.movito.themoviedbapi.TmdbMovies.TMDB_METHOD_MOVIE;

import info.movito.themoviedbapi.model.Reviews;
import info.movito.themoviedbapi.model.core.ResultsPage;
import info.movito.themoviedbapi.tools.ApiUrl;


public class TmdbReviews extends AbstractTmdbApi {

    TmdbReviews(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    public ReviewResultsPage getReviews(int movieId, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, "reviews");

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        return mapJsonResult(apiUrl, ReviewResultsPage.class);
    }


    public static class ReviewResultsPage extends ResultsPage<Reviews> {

    }

}
