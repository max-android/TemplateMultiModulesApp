package com.example.featurePeoples.peoples

import com.example.common.BaseViewModel
import com.example.domain.model.peoples.PeopleModel

sealed class PeoplesState : BaseViewModel.BaseViewState
data class PeoplesListSuccess(val peoples: List<PeopleModel>) : PeoplesState()
data class SearchPeoplesListSuccess(val peoples: List<PeopleModel>) : PeoplesState()
object PeoplesListEmpty : PeoplesState()
object PeoplesListLoading : PeoplesState()
data class PeoplesListError(val exception: Throwable) : PeoplesState()