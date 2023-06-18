package com.example.featurePeoples.peoples

import com.example.common.BaseViewModel

sealed interface PeoplesEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowPeopleDetailEvent(val peopleId: String): PeoplesEvent
@JvmInline
value class SearchPeopleEvent(val search: String): PeoplesEvent