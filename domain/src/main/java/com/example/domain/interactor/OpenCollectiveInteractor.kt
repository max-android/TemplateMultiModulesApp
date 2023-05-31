package com.example.domain.interactor

import com.example.domain.model.openCollective.EventModel
import com.example.domain.model.openCollective.MemberModel
import com.example.domain.repository.OpenCollectiveRepository
import javax.inject.Inject

class OpenCollectiveInteractor @Inject constructor(
    private val openCollectiveRepository: OpenCollectiveRepository
) {

    suspend fun members(limit: Int, skip: Int): List<MemberModel> {
        return openCollectiveRepository.members(limit, skip)
    }

    suspend fun events(limit: Int, skip: Int): List<EventModel> {
        return openCollectiveRepository.events(limit, skip)
    }

    suspend fun event(eventSlug: String): EventModel {
        return openCollectiveRepository.event(eventSlug)
    }

}