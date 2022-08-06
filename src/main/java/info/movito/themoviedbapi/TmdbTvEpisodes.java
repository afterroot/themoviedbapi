/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi;

import static info.movito.themoviedbapi.TmdbTV.TMDB_METHOD_TV;
import static info.movito.themoviedbapi.TmdbTvEpisodes.EpisodeMethod.credits;
import static info.movito.themoviedbapi.TmdbTvSeasons.TMDB_METHOD_TV_SEASON;
import static info.movito.themoviedbapi.Utils.asStringArray;

import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.tools.ApiUrl;


public class TmdbTvEpisodes extends AbstractTmdbApi {


    public static final String TMDB_METHOD_TV_EPISODE = "episode";


    TmdbTvEpisodes(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    public TvEpisode getEpisode(int seriesId, int seasonNumber, int episodeNumber, String language, EpisodeMethod... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_TV, seriesId, TMDB_METHOD_TV_SEASON, seasonNumber, TMDB_METHOD_TV_EPISODE, episodeNumber);

        apiUrl.addLanguage(language);

        apiUrl.appendToResponse(asStringArray(appendToResponse));

        return mapJsonResult(apiUrl, TvEpisode.class);
    }

    public Credits getCredits(int seriesId, int seasonNumber, int episodeNumber, String language) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_TV, seriesId, TMDB_METHOD_TV_SEASON, seasonNumber, TMDB_METHOD_TV_EPISODE, episodeNumber, credits);

        apiUrl.addLanguage(language);

        return mapJsonResult(apiUrl, Credits.class);
    }


    public static enum EpisodeMethod {
        // base method shared by all tv apis
        credits, external_ids, images, videos
        // specific method for episodes
        // ...tbd
    }
}
