package com.example.featurePeoples.characters

import com.example.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleCharactersViewModel @Inject constructor() : BaseViewModel() {

    override fun obtainEvent(event: BaseEvent?) {
    }

}