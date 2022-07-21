package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import info.movito.themoviedbapi.model.Multi.MediaType
import info.movito.themoviedbapi.model.people.PersonPeople
import info.movito.themoviedbapi.model.tv.TvSeries

/**
 * Interface that is needed for /search/multi request
 *
 *
 * [NetworkMovie], [PersonPeople] and
 * [TvSeries] implement this interface.
 *
 * Each of them returns corresponding [MediaType]
 *
 * @see info.movito.themoviedbapi.TmdbSearch.searchMulti
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "media_type")
@JsonSubTypes(
    JsonSubTypes.Type(value = NetworkMovie::class, name = "movie"),
    JsonSubTypes.Type(value = PersonPeople::class, name = "person"),
    JsonSubTypes.Type(value = TvSeries::class, name = "tv")
)
interface Multi {
    enum class MediaType {
        MOVIE, PERSON, TV_SERIES
    }

    /**
     * Used to determine type Multi object without `instanceOf()` or `getClass`
     */
    val mediaType: MediaType?
}
