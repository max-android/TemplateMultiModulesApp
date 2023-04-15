package com.example.template.navigation

import android.content.Context
import com.example.featureProfile.ProfileScreenFactory
import com.example.featureRoot.RootScreenFactory
import com.example.featureShows.ShowsScreenFactory
import com.example.navigation.ComposeNavFactory
import com.example.navigation.ScreenStarter
import javax.inject.Inject

class Starter @Inject constructor(private val context: Context) : ScreenStarter {

    override fun startRoot(): ComposeNavFactory {
        return RootScreenFactory()
    }

    override fun startShows(): ComposeNavFactory {
        return ShowsScreenFactory()
    }

    //TODO удалить после разработки пары модулей
    override fun startProfile(): ComposeNavFactory {
        return ProfileScreenFactory()
    }

}