package com.example.data.network

import com.example.data.dto.players.GameDto
import com.example.data.dto.players.GamesDto
import com.example.data.dto.players.PlayerDto
import com.example.data.dto.players.PlayersDto
import com.example.data.dto.players.TeamDto
import com.example.data.dto.players.TeamsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayersRestService {

    //https://www.balldontlie.io/api/v1/players
    @GET("players")
    suspend fun players(): Response<PlayersDto>

    @GET("players/{ID}")
    suspend fun player(@Path("ID") id: String): Response<PlayerDto>

    //https://www.balldontlie.io/api/v1/teams
    @GET("teams")
    suspend fun teams(): Response<TeamsDto>

    //https://www.balldontlie.io/api/v1/teams/<ID>
    @GET("teams/{ID}")
    suspend fun team(@Path("ID") id: String): Response<TeamDto>

    //https://www.balldontlie.io/api/v1/games
    //?seasons[]=2018&team_ids[]=1
    @GET("games")
    suspend fun games(): Response<GamesDto>

    //https://www.balldontlie.io/api/v1/games/<ID>
    @GET("games/{ID}")
    suspend fun game(@Path("ID") id: String): Response<GameDto>

}