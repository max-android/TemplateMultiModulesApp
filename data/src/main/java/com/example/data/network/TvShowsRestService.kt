package com.example.data.network

import com.example.data.dto.shows.CrewDto
import com.example.data.dto.episodes.EpisodesDto
import com.example.data.dto.episodes.GuestCastEpisodesDto
import com.example.data.dto.episodes.GuestCrewEpisodesDto
import com.example.data.dto.peoples.cast.PeopleCastCreditsDto
import com.example.data.dto.peoples.characters.CharacterDto
import com.example.data.dto.peoples.person.PeopleDto
import com.example.data.dto.peoples.person.SearchPeopleDto
import com.example.data.dto.shows.seasons.SeasonsDto
import com.example.data.dto.shows.CastDto
import com.example.data.dto.shows.SearchShowsDto
import com.example.data.dto.shows.ShowDto
import com.example.data.dto.shows.image.ShowsImageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowsRestService {

    /**
     * ------------------------Shows--------------------------------------
     */

    @GET("shows")
    suspend fun allShows(): Response<List<ShowDto>>

    @GET("shows/{id}")
    suspend fun detailShow(@Path("id") id: String): Response<ShowDto>

    //https://api.tvmaze.com/shows/1/seasons
    @GET("shows/{id}/seasons")
    suspend fun seasonsShows(@Path("id") id: String): Response<List<SeasonsDto>>

    //https://api.tvmaze.com/shows/1/crew
    @GET("shows/{id}/crew")
    suspend fun crewShows(@Path("id") id: String): Response<List<CrewDto>>

    //https://api.tvmaze.com/shows/1/cast
    @GET("shows/{id}/cast")
    suspend fun castShows(@Path("id") id: String): Response<List<CastDto>>

    //https://api.tvmaze.com/shows/1/images
    @GET("shows/{id}/images")
    suspend fun imagesShows(@Path("id") id: String): Response<List<ShowsImageDto>>


    //https://api.tvmaze.com/search/shows?q=girls
    @GET("search/shows")
    suspend fun searchShows(@Query("q") shows: String): Response<List<SearchShowsDto>>


    //не надо
    //https://api.tvmaze.com/shows/1/episodebynumber?season=1&number=1
    //https://api.tvmaze.com/schedule/full

    /**
     * ------------------------Episodes--------------------------------------
     */

    //https://api.tvmaze.com/shows/1/episodes
    @GET("shows/{id}/episodes")
    suspend fun episodesShows(@Path("id") id: String): Response<List<EpisodesDto>>

    //https://api.tvmaze.com/episodes/1
    @GET("episodes/{id}")
    suspend fun detailEpisode(@Path("id") id: String): Response<EpisodesDto>

    // https://api.tvmaze.com/episodes/1/guestcast
    @GET("episodes/{id}/guestcast")
    suspend fun guestCastEpisode(@Path("id") id: String): Response<List<GuestCastEpisodesDto>>

    //https://api.tvmaze.com/episodes/1/guestcrew
    @GET("episodes/{id}/guestcrew")
    suspend fun guestCrewEpisode(@Path("id") id: String): Response<List<GuestCrewEpisodesDto>>


    /**
     * ------------------------Peoples--------------------------------------
     */

    @GET("people")
    suspend fun allPeoples(): Response<List<PeopleDto>>

    @GET("people/{id}")
    suspend fun detailPeople(@Path("id") id: String): Response<PeopleDto>

    @GET("people/{id}/castcredits")
    suspend fun castCreditsPeople(@Path("id") id: String): Response<List<PeopleCastCreditsDto>>

    @GET("characters/{id}")
    suspend fun charactersPeople(@Path("id") id: String): Response<List<CharacterDto>>

    //https://api.tvmaze.com/search/people?q=lauren
    @GET("search/people")
    suspend fun searchPeoples(@Query("q") people: String): Response<List<SearchPeopleDto>>

}