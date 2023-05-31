package com.example.domain.repository

import com.example.domain.model.openCollective.EventModel
import com.example.domain.model.openCollective.MemberModel

interface OpenCollectiveRepository {

    suspend fun members(limit: Int, skip: Int): List<MemberModel>

    suspend fun events(limit: Int, skip: Int): List<EventModel>

    suspend fun event(eventSlug: String): EventModel
}