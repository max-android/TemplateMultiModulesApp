package com.example.featurePeoples.detailPeoples

import com.example.common.BaseViewModel
import com.example.domain.model.peoples.PeopleModel

sealed class PeopleDetailState : BaseViewModel.BaseViewState
data class PeopleDetailSuccess(val people: PeopleModel) : PeopleDetailState()
object PeopleDetailEmpty : PeopleDetailState()
object PeopleDetailLoading : PeopleDetailState()
data class PeopleDetailError(val exception: Throwable) : PeopleDetailState()