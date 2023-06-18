package com.example.featurePeoples.peoples

import com.example.common.BaseViewModel

sealed interface PeoplesSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class PeopleDetailEffect(val peopleId: String): PeoplesSideEffect