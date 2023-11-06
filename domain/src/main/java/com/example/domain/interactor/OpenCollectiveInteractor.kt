package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.openCollective.EventModel
import com.example.domain.model.openCollective.MemberModel
import com.example.domain.repository.OpenCollectiveRepository
import javax.inject.Inject

class OpenCollectiveInteractor @Inject constructor(
    private val openCollectiveRepository: OpenCollectiveRepository
) {

    suspend fun members(limit: Int, skip: Int): ResultState<List<MemberModel>> {
        return try {
            val members = openCollectiveRepository.members(limit, skip)
            ResultState.Success(members)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun events(limit: Int, skip: Int): ResultState<List<EventModel>> {
        return try {
            val events = openCollectiveRepository.events(limit, skip)
            ResultState.Success(events)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun event(eventSlug: String): ResultState<EventModel> {
        return try {
            val event = openCollectiveRepository.event(eventSlug)
            ResultState.Success(event)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}