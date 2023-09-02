package com.example.template.navigation

import android.content.Context
import com.example.featurePeoples.characters.PeopleCharactersScreenFactory
import com.example.featurePeoples.detailPeoples.PeopleDetailScreenFactory
import com.example.featurePeoples.peoples.PeoplesScreenFactory
import com.example.featureProfile.ProfileScreenFactory
import com.example.featureRoot.RootScreenFactory
import com.example.featureSeasons.ShowsSeasonsScreenFactory
import com.example.featureShows.castShows.ShowsCastScreenFactory
import com.example.featureShows.crewShows.ShowsCrewScreenFactory
import com.example.featureShows.shows.ShowsScreenFactory
import com.example.featureShows.detailShows.ShowsDetailScreenFactory
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

    override fun startShowsDetail(): ComposeNavFactory {
        return ShowsDetailScreenFactory()
    }

    override fun startShowsSeasons(): ComposeNavFactory {
        return ShowsSeasonsScreenFactory()
    }

    override fun startShowsCrew(): ComposeNavFactory {
        return ShowsCrewScreenFactory()
    }

    override fun startShowsCast(): ComposeNavFactory {
        return ShowsCastScreenFactory()
    }

    override fun startPeoples(): ComposeNavFactory {
        return PeoplesScreenFactory()
    }

    override fun startPeopleDetail(): ComposeNavFactory {
        return PeopleDetailScreenFactory()
    }

    override fun startPeopleCharacters(): ComposeNavFactory {
        return PeopleCharactersScreenFactory()
    }

    //TODO удалить после разработки пары модулей
    override fun startProfile(): ComposeNavFactory {
        return ProfileScreenFactory()
    }

}