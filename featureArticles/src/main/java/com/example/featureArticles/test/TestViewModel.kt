package com.example.featureArticles.test

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.clearText
import androidx.compose.foundation.text2.input.delete
import androidx.compose.foundation.text2.input.forEachTextValue
import androidx.compose.foundation.text2.input.insert
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class TestViewModel @Inject constructor() : BaseViewModel() {

    override fun obtainEvent(event: BaseEvent?) {

    }

    @OptIn(ExperimentalFoundationApi::class)
    val username = TextFieldState()


//    @OptIn(ExperimentalFoundationApi::class)
//    val userNameHasError: StateFlow<Boolean> =
//        username.textAsFlow()
//            .debounce(500)
//            .mapLatest { true }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000),
//                initialValue = false
//            )
//
//    var userNameHasError2 = mutableStateOf(false)

    @OptIn(ExperimentalFoundationApi::class)
    fun validateUsername() {
        viewModelScope.launch {
            username.forEachTextValue { text ->
                val length = text.toString().length
                if (length == 1 && text.toString() != "8") {
                    setIntro()
                }
                if (length >= 11) {
                    setEnd(length)
                }
                Log.i("--TEXT", "---------" + text.length.toString())
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun clearField() {
        username.edit {
            delete(3, length)
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun clearAllField() {
        username.clearText()
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun setIntro() {
        username.edit {
            insert(0, "8")
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun setEnd(length: Int) {
        username.edit {
            delete(11, length)
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun clear2() {
        username.edit {
            Log.i("--TEXT", "---------length:" + selectionInChars.length.toString())

            insert(selectionInChars.start, "11")
            insert(selectionInChars.end, "22")

        }
    }
    //https://scribe.rip/@astamato/basictextfield2-a-textfield-of-dreams-1-2-0103fd7cc0ec

//fun replace(...)
//    fun append(...)
//    fun insert(...)
//    fun delete(...)
//
//    fun selectAll(...)
//    fun selectCharsIn(...)
//    fun placeCursorAfterCharAt(...)
}