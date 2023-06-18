package com.example.featurePeoples.detailPeoples

import com.example.common.BaseViewModel

sealed interface PeopleDetailSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class PeopleCharactersEffect(val peopleId: String): PeopleDetailSideEffect
@JvmInline
value class ShowSitePeoplesEffect(val url: String): PeopleDetailSideEffect