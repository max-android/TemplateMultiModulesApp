package com.example.data.network

import com.example.data.dto.openCollective.EventDto
import com.example.data.dto.openCollective.MemberDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenCollectiveRestService {

//https://opencollective.com/webpack/members.json?limit=10&offset=0

    @GET("webpack/members.json")
    suspend fun members(
        @Query("limit") limit: Int,
        @Query("offset") skip: Int,
    ): Response<List<MemberDto>>

    //https://opencollective.com/sustainoss/events.json?limit=10&offset=0

    @GET("sustainoss/events.json")
    suspend fun events(
        @Query("limit") limit: Int,
        @Query("offset") skip: Int,
    ): Response<List<EventDto>>

    //https://opencollective.com/sustainoss/events/sustainoss-pycon-2023-meetup-fa5abf53.json

    @GET("sustainoss/events/{eventSlug}.json")
    suspend fun event(
        @Path("eventSlug") eventSlug: String
    ): Response<EventDto>

}