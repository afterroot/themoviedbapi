/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

@file:Suppress("DEPRECATION")

package info.movito.themoviedbapi

import com.afterroot.tmdbapi.TmdbTrending
import info.movito.themoviedbapi.model.JobDepartment
import info.movito.themoviedbapi.model.config.ImagesConfig
import info.movito.themoviedbapi.tools.ApiUrl
import info.movito.themoviedbapi.tools.MovieDbException
import info.movito.themoviedbapi.tools.RequestCountLimitException
import info.movito.themoviedbapi.tools.RequestMethod
import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

/**
 * The MovieDb API
 *
 * This is for version 3 of the API as specified here: http://help.themoviedb.org/kb/api/about-3
 *
 * @author Holger Brandl
 * @author Sandip Vaghela
 */
class TmdbApi @JvmOverloads constructor(
    /**
     * Get the API key that is to be used by this instance
     */
    private val apiKey: String,
    private val okHttpClient: OkHttpClient,
    /**
     * Automatically retry after indicated amount of seconds if we hit the request limit.
     * See http://docs.themoviedb.apiary.io/introduction/request-rate-limiting for details
     */
    private var autoRetry: Boolean = true,
) {
    @Deprecated("Use new api from V2")
    var configuration: ImagesConfig

    /**
     * Uses the instance's api key to request information from api.tmdb.org.
     *
     *
     * Depending on the `autoRetry` setting this method will stall and internally recurse until the request was  successfully
     * processed.
     *
     * @param apiUrl        The url to be requested
     * @return
     */
    fun requestWebPage(apiUrl: ApiUrl, method: String = RequestMethod.GET): String? {
        apiUrl.addParam(AbstractTmdbApi.PARAM_API_KEY, apiKey)
        return try {
            getResponse(apiUrl.buildUrl().toString(), method)
        } catch (rcle: RequestCountLimitException) {
            if (autoRetry) {
                Utils.sleep(rcle.retryAfter * 1000)
                requestWebPage(apiUrl, method)
            } else {
                // just return the orignal json response if autoRetry is disabled. This will cause a ResponseStatusException.
                rcle.message
            }
        }
    }

    private fun getResponse(
        url: String,
        method: String = RequestMethod.GET,
        requestBody: RequestBody? = null,
    ): String {
        val request = Request.Builder()
            .url(url).method(method, requestBody)
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            return response.body.string()
        }
    }

    val timezones: TmdbTimezones.TimeZones
        get() = TmdbTimezones(this).timezones

    //
    // accessors for the different parts of the api
    //
    val account: TmdbAccount
        get() = TmdbAccount(this)

    val lists: TmdbLists
        get() = TmdbLists(this)

    val movies: TmdbMovies
        get() = TmdbMovies(this)

    val search: TmdbSearch
        get() = TmdbSearch(this)

    val genre: TmdbGenre
        get() = TmdbGenre(this)

    val company: TmdbCompany
        get() = TmdbCompany(this)

    val collections: TmdbCollections
        get() = TmdbCollections(this)

    val people: TmdbPeople
        get() = TmdbPeople(this)

    val authentication: TmdbAuthentication
        get() = TmdbAuthentication(this)

    val changes: TmdbChanges
        get() = TmdbChanges(this)

    val jobs: List<JobDepartment>
        get() = TmdbJobs(this).jobs

    val keywords: TmdbKeywords
        get() = TmdbKeywords(this)

    val reviews: TmdbReviews
        get() = TmdbReviews(this)

    val tvSeries: TmdbTV
        get() = TmdbTV(this)

    val tvSeasons: TmdbTvSeasons
        get() = TmdbTvSeasons(this)

    val tvEpisodes: TmdbTvEpisodes
        get() = TmdbTvEpisodes(this)

    val find: TmdbFind
        get() = TmdbFind(this)

    val trending: TmdbTrending
        get() = TmdbTrending(this)

    init { // Omit
        try {
            configuration = TmdbConfig(this).config.imagesConfig!!
        } catch (ex: MovieDbException) {
            throw ex
        } catch (ex: Throwable) {
            throw MovieDbException("Failed to read configuration", ex)
        }
    }
}
