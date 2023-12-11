package com.example.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import com.example.common.EMPTY_VALUE

class ProfileService @Inject constructor(private val context: Context) {

    private val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(PROFILE_STORE, Context.MODE_PRIVATE)

    var profileName: String
        get() {
            return sharedPreferences.getString(PREF_KEY_NAME, EMPTY_VALUE).orEmpty()
        }
        set(value) {
            sharedPreferences.edit { putString(PREF_KEY_NAME, value) }
        }

    var profilePhone: String
        get() {
            return sharedPreferences.getString(PREF_KEY_PHONE, EMPTY_VALUE).orEmpty()
        }
        set(value) {
            sharedPreferences.edit { putString(PREF_KEY_PHONE, value) }
        }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        private const val PROFILE_STORE = "PROFILE_STORE"
        private const val PREF_KEY_NAME = "PREF_KEY_NAME"
        private const val PREF_KEY_PHONE = "PREF_KEY_PHONE"
    }
}