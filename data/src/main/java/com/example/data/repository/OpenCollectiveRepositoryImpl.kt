package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toEventModel
import com.example.data.mapper.toListEventModel
import com.example.data.mapper.toListMemberModel
import com.example.data.network.OpenCollectiveRestService
import com.example.domain.model.openCollective.EventModel
import com.example.domain.model.openCollective.MemberModel
import com.example.domain.repository.OpenCollectiveRepository
import javax.inject.Inject

class OpenCollectiveRepositoryImpl @Inject constructor(
    private val openCollectiveRestService: OpenCollectiveRestService
) : OpenCollectiveRepository {

    override suspend fun members(limit: Int, skip: Int): List<MemberModel> {
        return openCollectiveRestService.members(limit, skip).handleBodyDto().toListMemberModel()
    }

    override suspend fun events(limit: Int, skip: Int): List<EventModel> {
        return openCollectiveRestService.events(limit, skip).handleBodyDto().toListEventModel()
    }

    override suspend fun event(eventSlug: String): EventModel {
        return openCollectiveRestService.event(eventSlug).handleBodyDto().toEventModel()
    }

}