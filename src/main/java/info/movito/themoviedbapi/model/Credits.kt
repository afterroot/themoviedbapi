package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import info.movito.themoviedbapi.model.core.IdElement
import info.movito.themoviedbapi.model.people.Person
import info.movito.themoviedbapi.model.people.PersonCast
import info.movito.themoviedbapi.model.people.PersonCrew

data class Credits(
    @JsonProperty("crew")
    var crew: List<PersonCrew>? = null,
    @JsonProperty("cast")
    var cast: List<PersonCast>? = null,
    @JsonProperty("guest_stars")
    var guestStars: List<PersonCast>? = null
) : IdElement() {
    /**
     * Convenience wrapper to get all people involved in the movie>
     */
    val all: List<Person>
        get() {
            val involved: MutableList<Person> = ArrayList()
            involved.apply {
                crew?.let { addAll(it) }
                cast?.let { addAll(it) }
                guestStars?.let { addAll(it) }
            }
            return involved
        }
}
