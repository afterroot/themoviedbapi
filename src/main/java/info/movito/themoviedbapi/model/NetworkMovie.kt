package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import info.movito.themoviedbapi.TmdbMovies
import info.movito.themoviedbapi.Types
import info.movito.themoviedbapi.model.core.IdElement
import info.movito.themoviedbapi.model.core.MovieKeywords
import info.movito.themoviedbapi.model.core.ResultsPage
import info.movito.themoviedbapi.model.keywords.Keyword
import info.movito.themoviedbapi.model.people.PersonCast
import info.movito.themoviedbapi.model.people.PersonCrew

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
data class NetworkMovie(
    @JsonProperty("adult") val adult: Boolean? = null,
    @JsonProperty("backdrop_path") val backdropPath: String? = null,
    @JsonProperty("belongs_to_collection") val belongsToCollection: Collection? = null,
    @JsonProperty("budget") val budget: Int? = null,
    @JsonProperty("genres")
    val genres: List<Genre>? = null,
    @JsonProperty("genre_ids")
    val genreIds: List<Int>? = null,
    @JsonProperty("homepage")
    val homepage: String? = null,
    @JsonProperty("imdb_id")
    val imdbId: String? = null,
    @JsonProperty("original_language")
    val originalLanguage: String? = null,
    @JsonProperty("original_title")
    val originalTitle: String? = null,
    @JsonProperty("overview")
    val overview: String? = null,
    @JsonProperty("popularity")
    val popularity: Double? = null,
    @JsonProperty("poster_path")
    val posterPath: String? = null,
    @JsonProperty("production_companies")
    val productionCompanies: List<ProductionCompany>? = null,
    @JsonProperty("production_countries")
    val productionCountries: List<ProductionCountry>? = null,
    @JsonProperty("release_date")
    val releaseDate: String? = null,
    @JsonProperty("revenue")
    val revenue: Long? = null,
    @JsonProperty("runtime")
    val runtime: Int? = null,
    @JsonProperty("spoken_languages")
    val spokenLanguages: List<Language>? = null,
    @JsonProperty("status")
    val status: String? = null,
    @JsonProperty("tagline")
    val tagline: String? = null,
    @JsonProperty("title")
    val title: String? = null,
    @JsonProperty("video")
    val video: Boolean? = null,
    @JsonProperty("vote_average")
    val voteAverage: Double? = null,
    @JsonProperty("vote_count")
    val voteCount: Int? = null,
    @JsonProperty("rating")
    var userRating: Float = 0f,
    // Appendable responses
    @JsonProperty("alternative_titles")
    var alternativeTitles: MoviesAlternativeTitles? = null,
    @JsonProperty("credits")
    var credits: Credits? = null,
    @JsonProperty("images")
    var images: MovieImages? = null,
    @JsonProperty("keywords")
    var keywords: MovieKeywords? = null,
    @JsonProperty("release_dates")
    var releases: TmdbMovies.ReleaseInfoResults? = null,
    @JsonProperty("videos")
    var videos: Video.Results? = null,
    @JsonProperty("translations")
    var translations: MovieTranslations? = null,
    @JsonProperty("similar")
    var similarMovies: ResultsPage<NetworkMovie>? = null,
    @JsonProperty("recommendations")
    val recommendedMovies: ResultsPage<NetworkMovie>? = null,
    @JsonProperty("reviews")
    var reviews: ResultsPage<Reviews>? = null,
    @JsonProperty("lists")
    var lists: ResultsPage<MovieList>? = null
) : IdElement(), Multi {
    override val mediaType: Multi.MediaType
        get() = Multi.MediaType.MOVIE

    fun alternativeTitles(): List<AlternativeTitle>? = alternativeTitles?.titles

    fun cast(): List<PersonCast>? = credits?.cast

    fun crew(): List<PersonCrew>? = credits?.crew

    fun images(vararg artworkTypes: ArtworkType?): List<Artwork>? = images?.getAll(*artworkTypes)

    fun keywords(): List<Keyword>? = keywords?.keywords

    fun releases(): List<ReleaseInfo>? = releases?.results

    fun videos(): List<Video>? = videos?.videos

    fun year(): String? = releaseDate?.substring(0, 4)

    companion object {
        fun type(): Int {
            return Types.MOVIE
        }
    }
}
