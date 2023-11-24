package com.example.template.navigation

import android.content.Context
import com.example.featureArticles.ArticlesScreenFactory
import com.example.featureArticles.test.TestScreenFactory
import com.example.featureEpisodes.castEpisode.EpisodeCastScreenFactory
import com.example.featureEpisodes.crewEpisode.EpisodeCrewScreenFactory
import com.example.featureEpisodes.detailEpisodes.EpisodeDetailScreenFactory
import com.example.featureEpisodes.episodes.EpisodesScreenFactory
import com.example.featureNews.news.NewsScreenFactory
import com.example.featureNews.categoryNews.NewsCategoryScreenFactory
import com.example.featurePeoples.characters.PeopleCharactersScreenFactory
import com.example.featurePeoples.detailPeoples.PeopleDetailScreenFactory
import com.example.featurePeoples.peoples.PeoplesScreenFactory
import com.example.featureProfile.ProfileScreenFactory
import com.example.featureOpen.OpenScreenFactory
import com.example.featurePlayer.PlayersScreenFactory
import com.example.featureRoot.root.RootScreenFactory
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

    override fun startEpisodes(): ComposeNavFactory {
        return EpisodesScreenFactory()
    }

    override fun startEpisodeDetail(): ComposeNavFactory {
        return EpisodeDetailScreenFactory()
    }

    override fun startEpisodeCrew(): ComposeNavFactory {
        return EpisodeCrewScreenFactory()
    }

    override fun startEpisodeCast(): ComposeNavFactory {
        return EpisodeCastScreenFactory()
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

    override fun startOpen(): ComposeNavFactory {
        return OpenScreenFactory()
    }

    override fun startArticles(): ComposeNavFactory {
        return ArticlesScreenFactory()
    }

    override fun startNews(): ComposeNavFactory {
        return NewsScreenFactory()
    }

    override fun startNewsCategory(): ComposeNavFactory {
        return NewsCategoryScreenFactory()
    }

    override fun startProfile(): ComposeNavFactory {
        return ProfileScreenFactory()
    }

    override fun startPlayers(): ComposeNavFactory {
        return PlayersScreenFactory()
    }

    override fun startTest(): ComposeNavFactory {
        return TestScreenFactory()
    }
}