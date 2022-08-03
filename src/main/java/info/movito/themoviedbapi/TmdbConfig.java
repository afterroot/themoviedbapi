/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi;

import info.movito.themoviedbapi.model.config.ConfigResults;
import info.movito.themoviedbapi.tools.ApiUrl;


class TmdbConfig extends AbstractTmdbApi {

    public static final String TMDB_METHOD_CONFIGURATION = "configuration";


    TmdbConfig(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    public ConfigResults getConfig() {
        return mapJsonResult(new ApiUrl(TMDB_METHOD_CONFIGURATION), ConfigResults.class);
    }

}
