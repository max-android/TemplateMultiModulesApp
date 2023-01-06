package com.example.template.navigation

import android.content.Context
import com.example.featureProfile.ProfileScreenFactory
import com.example.featureRoot.RootScreenFactory
import com.example.navigation.ComposeNavFactory
import com.example.navigation.ScreenStarter
import javax.inject.Inject

class Starter @Inject constructor(private val context: Context) : ScreenStarter {

    override fun startRoot(): ComposeNavFactory {
        return RootScreenFactory()
    }

    override fun startProfile(): ComposeNavFactory {
        return ProfileScreenFactory()
    }

}