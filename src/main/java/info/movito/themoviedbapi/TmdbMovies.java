/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static info.movito.themoviedbapi.TmdbAccount.PARAM_SESSION;
import static info.movito.themoviedbapi.TmdbMovies.MovieMethod.videos;
import static info.movito.themoviedbapi.Utils.asStringArray;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import info.movito.themoviedbapi.model.AlternativeTitle;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.MovieTranslations;
import info.movito.themoviedbapi.model.MoviesAlternativeTitles;
import info.movito.themoviedbapi.model.NetworkMovie;
import info.movito.themoviedbapi.model.ReleaseInfo;
import info.movito.themoviedbapi.model.Translation;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.changes.ChangesItems;
import info.movito.themoviedbapi.model.core.IdElement;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.SessionToken;
import info.movito.themoviedbapi.model.keywords.Keyword;
import info.movito.themoviedbapi.model.providers.ProviderResults;
import info.movito.themoviedbapi.tools.ApiUrl;


public class TmdbMovies extends AbstractTmdbApi {

    // API Methods
    public static final String TMDB_METHOD_MOVIE = "movie";
    private static final String PARAM_START_DATE = "start_date";
    private static final String PARAM_END_DATE = "end_date";
    private static final String PARAM_COUNTRY = "country";
    private static final String PARAM_REGION = "region";


    public TmdbMovies(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    /**
     * This method is used to retrieve all of the basic movie information.
     * <p>
     * It will return the single highest rated poster and backdrop.
     */
    public NetworkMovie getMovie(int movieId, String language, MovieMethod... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId);

        apiUrl.addLanguage(language);

        apiUrl.appendToResponse(asStringArray(appendToResponse));

        return mapJsonResult(apiUrl, NetworkMovie.class);
    }

    /**
     * This method is used to retrieve all of the alternative titles we have for a particular movie.
     */
    public List<AlternativeTitle> getAlternativeTitles(int movieId, String country) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.alternative_titles);

        if (StringUtils.isNotBlank(country)) {
            apiUrl.addParam(PARAM_COUNTRY, country);
        }


        return mapJsonResult(apiUrl, MoviesAlternativeTitles.class).getTitles();
    }

    public Credits getCredits(int movieId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.credits);

        return mapJsonResult(apiUrl, Credits.class);
    }

    /**
     * This method should be used when you’re wanting to retrieve all of the images for a particular movie.
     */
    public MovieImages getImages(int movieId, String language) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.images);

        apiUrl.addLanguage(language);

        return mapJsonResult(apiUrl, MovieImages.class);
    }

    /**
     * This method is used to retrieve all of the keywords that have been added to a particular movie.
     * <p>
     * Currently, only English keywords exist.
     */
    public List<Keyword> getKeywords(int movieId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.keywords);


        return mapJsonResult(apiUrl, KeywordResults.class).results;
    }

    /**
     * This method is used to retrieve all of the release and certification data we have for a specific movie.
     */
    public List<ReleaseInfo> getReleaseInfo(int movieId, String language) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.release_dates);


        apiUrl.addLanguage(language);

        return mapJsonResult(apiUrl, ReleaseInfoResults.class).results;
    }

    /**
     * This method is used to retrieve all of the videos for a particular movie.
     * <p>
     * Supported sites are YouTube and QuickTime.
     */
    public List<Video> getVideos(int movieId, String language) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, videos);

        apiUrl.addLanguage(language);

        return mapJsonResult(apiUrl, Video.Results.class).getVideos();
    }

    /**
     * This method is used to retrieve a list of the available translations for a specific movie.
     */
    public List<Translation> getTranslations(int movieId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.translations);

        return mapJsonResult(apiUrl, MovieTranslations.class).getTranslations();
    }

    /**
     * The similar movies method will let you retrieve the similar movies for a particular movie.
     * <p>
     * This data is created dynamically but with the help of users votes on TMDb.
     * <p>
     * The data is much better with movies that have more keywords
     */
    public MovieResultsPage getSimilarMovies(int movieId, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.similar);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        return mapJsonResult(apiUrl, MovieResultsPage.class);
    }

    /**
     * The recomendations movies method will let you retrieve the reccomended movies for a particular movie.
     * <p>
     * This data is created dynamically but with the help of TMDb internal algorithm.
     * <p>
     * The data is much better with movies that are more popular
     */
    public MovieResultsPage getRecommendedMovies(int movieId, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.recommendations);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        return mapJsonResult(apiUrl, MovieResultsPage.class);
    }

    /**
     * Get the lists that the movie belongs to
     */
    public TmdbAccount.MovieListResultsPage getListsContaining(int movieId, SessionToken sessionToken, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.lists);

        apiUrl.addParam(PARAM_SESSION, sessionToken);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        return mapJsonResult(apiUrl, TmdbAccount.MovieListResultsPage.class);
    }

    /**
     * Get the changes for a specific movie id.
     * <p>
     * Changes are grouped by key, and ordered by date in descending order.
     * <p>
     * By default, only the last 24 hours of changes are returned.
     * <p>
     * The maximum number of days that can be returned in a single request is 14.
     * <p>
     * The language is present on fields that are translatable.
     * <p>
     * TODO: DOES NOT WORK AT THE MOMENT. This is due to the "value" item changing type in the ChangeItem
     *
     * @param startDate the start date of the changes, optional
     * @param endDate   the end date of the changes, optional
     */
    public ChangesItems getChanges(int movieId, String startDate, String endDate) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.changes);

        if (StringUtils.isNotBlank(startDate)) {
            apiUrl.addParam(PARAM_START_DATE, startDate);
        }

        if (StringUtils.isNotBlank(endDate)) {
            apiUrl.addParam(PARAM_END_DATE, endDate);
        }

        return mapJsonResult(apiUrl, ChangesItems.class);

    }

    /**
     * Powered by our partnership with JustWatch, you can query this method to get a list of the availabilities per country by provider.
     * <p>
     * This is not going to return full deep links, but rather, it's just enough information to display what's available where.
     * <p>
     * You can link to the provided TMDB URL to help support TMDB and provide the actual deep links to the content.
     * <p>
     * See: <a href="https://developers.themoviedb.org/3/movies/get-movie-watch-providers">API Docs</a>
     *
     * @param movieId The MovieId to retrieve watch providers for
     * @return Complete set of watch providers by country
     */
    public ProviderResults getWatchProviders(int movieId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, movieId, MovieMethod.watch_providers);

        return mapJsonResult(apiUrl, ProviderResults.class);
    }

    /**
     * This method is used to retrieve the newest movie that was added to TMDb.
     */
    public NetworkMovie getLatestMovie() {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, MovieMethod.latest);


        return mapJsonResult(apiUrl, NetworkMovie.class);
    }

    /**
     * Get the list of upcoming movies.
     * <p>
     * This list refreshes every day.
     * <p>
     * The maximum number of items this list will include is 100.
     * <p>
     * See https://developers.themoviedb.org/3/movies/get-upcoming
     */
    public MovieResultsPage getUpcoming(String language, Integer page, String region) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, MovieMethod.upcoming);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        if (isNotBlank(region)) {
            apiUrl.addParam(PARAM_REGION, region);
        }

        return mapJsonResult(apiUrl, MovieResultsPage.class);

    }

    /**
     * This method is used to retrieve the movies currently in theatres.
     * <p>
     * This is a curated list that will normally contain 100 movies. The default response will return 20 movies.
     */
    public MovieResultsPage getNowPlayingMovies(String language, Integer page, String region) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, MovieMethod.now_playing);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        if (isNotBlank(region)) {
            apiUrl.addParam(PARAM_REGION, region);
        }

        return mapJsonResult(apiUrl, MovieResultsPage.class);
    }

    /**
     * This method is used to retrieve the daily movie popularity list.
     * <p>
     * This list is updated daily. The default response will return 20 movies.
     */
    public MovieResultsPage getPopularMovies(String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, MovieMethod.popular);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);

        return mapJsonResult(apiUrl, MovieResultsPage.class);
    }

    /**
     * This method is used to retrieve the top rated movies that have over 10 votes on TMDb.
     * <p>
     * The default response will return 20 movies.
     */
    public MovieResultsPage getTopRatedMovies(String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_MOVIE, MovieMethod.top_rated);

        apiUrl.addLanguage(language);

        apiUrl.addPage(page);


        return mapJsonResult(apiUrl, MovieResultsPage.class);
    }


    // account_states and rating are not included as it wouldn't work anyway because of missing session id
    // --> inject session id into tmdb-instance?
    public enum MovieMethod {
        alternative_titles, credits, images, keywords, releases, release_dates,
        @Deprecated trailers,
        videos, // replacement for trailers
        translations, similar, recommendations,
        reviews, lists, changes, latest, upcoming, now_playing, popular, top_rated,
        watch_providers("watch/providers");

        private String name;

        MovieMethod() {
        }

        MovieMethod(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            if (name != null) {
                return name;
            }

            return super.toString();
        }
    }

    private static class KeywordResults extends IdElement {

        @JsonProperty("keywords")
        List<Keyword> results;
    }

    public static class ReleaseInfoResults extends IdElement {

        @JsonProperty("results")
        private List<ReleaseInfo> results;


        public List<ReleaseInfo> getResults() {
            return results;
        }
    }


}
