package com.example.featureOpen

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.openCollective.MemberModel

sealed class OpenState: BaseViewModel.BaseViewState
@Immutable
data class OpenListSuccess(val members: List<MemberModel>): OpenState()
data object OpenListLoading : OpenState()
class OpenListError(val exception: Throwable) : OpenState()