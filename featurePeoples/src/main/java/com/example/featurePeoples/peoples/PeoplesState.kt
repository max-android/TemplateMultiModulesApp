package com.example.featurePeoples.peoples

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.peoples.PeopleModel

sealed class PeoplesState : BaseViewModel.BaseViewState
@Immutable
data class PeoplesListSuccess(val peoples: List<PeopleModel>) : PeoplesState()
@Immutable
data class SearchPeoplesListSuccess(val peoples: List<PeopleModel>) : PeoplesState()
object PeoplesListEmpty : PeoplesState()
object PeoplesListLoading : PeoplesState()
data class PeoplesListError(val exception: Throwable) : PeoplesState()