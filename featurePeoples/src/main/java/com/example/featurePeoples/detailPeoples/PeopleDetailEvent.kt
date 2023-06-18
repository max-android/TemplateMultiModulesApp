package com.example.featurePeoples.detailPeoples

import com.example.common.BaseViewModel

sealed interface PeopleDetailEvent: BaseViewModel.BaseEvent
object ShowPeopleCharactersEvent: PeopleDetailEvent
@JvmInline
value class ShowSitePeoplesEvent(val url: String): PeopleDetailEvent