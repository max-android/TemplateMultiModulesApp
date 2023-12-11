package com.example.featureProfile.editProfile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.forEachTextValue
import androidx.compose.foundation.text2.input.setTextAndSelectAll
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.interactor.ProfileInteractor
import com.example.domain.model.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor
) : BaseViewModel() {

    @OptIn(ExperimentalFoundationApi::class)
    val profileName = TextFieldState()

    @OptIn(ExperimentalFoundationApi::class)
    val profilePhone = TextFieldState()

    private val stateProfileConfirmInternal = MutableStateFlow<Boolean>(false)
    val stateProfileConfirm: StateFlow<Boolean> = stateProfileConfirmInternal.asStateFlow()

    init {
        obtainEvent(InitProfileEvent)
    }

    @OptIn(ExperimentalFoundationApi::class)
    suspend fun validateProfile() {
        viewModelScope.launch {
            profileName.forEachTextValue { char ->
                stateProfileConfirmInternal.emit(char.toString().length > 2)
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is InitProfileEvent -> {
                loadProfile()
            }

            is UpdateProfileEvent -> {
                updateProfile()
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    private fun loadProfile() {
        viewModelScope.launch {
            val profile = profileInteractor.profile()
            profileName.setTextAndSelectAll(profile.name)
            profilePhone.setTextAndSelectAll(profile.phone)
            sendState(SuccessInitProfileState(profile))
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    private fun updateProfile() {
        viewModelScope.launch {
            profileInteractor.updateProfile(
                ProfileModel(
                    profileName.text.toString(),
                    profilePhone.text.toString()
                )
            )
        }
    }


}