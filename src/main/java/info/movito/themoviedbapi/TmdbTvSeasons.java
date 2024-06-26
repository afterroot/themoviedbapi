/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi;

import static info.movito.themoviedbapi.TmdbTV.TMDB_METHOD_TV;
import static info.movito.themoviedbapi.Utils.asStringArray;

import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.tools.ApiUrl;


public class TmdbTvSeasons extends AbstractTmdbApi {

    public static final String TMDB_METHOD_TV_SEASON = "season";


    TmdbTvSeasons(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    public TvSeason getSeason(int seriesId, int seasonNumber, String language, SeasonMethod... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_TV, seriesId, TMDB_METHOD_TV_SEASON, seasonNumber);

        apiUrl.addLanguage(language);

        apiUrl.appendToResponse(asStringArray(appendToResponse));

        return mapJsonResult(apiUrl, TvSeason.class);
    }


    public static enum SeasonMethod {
        // base method shared by all tv apis
        credits, external_ids, images, videos
        // specific method for episodes
        // ...tbd
    }
}
