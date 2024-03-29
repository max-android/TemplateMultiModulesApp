//блок, в котором вы объявляете репозитории для плагинов
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
//Определите блок dependencyResolutionManagement, в котором вы объявляете хранилища для зависимостей.
// Gradle использует их для разрешения зависимостей библиотек, которые вы включаете в проект.
// Вы также определяете RepositoriesMode. По умолчанию любые репозитории, которые вы объявляете в
// build.gradle.kts проекта, будут переопределять те, которые вы объявляете в settings.gradle.
// Установив repositoriesMode в FAIL_ON_PROJECT_REPOS, вы фактически принудительно завершаете
// сборку с ошибкой, если какие-либо репозитории объявлены вне этого файла.
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TemplateMultiModulesApp"
include(":app")
include(":data")
include(":domain")
include(":featureRoot")
include(":coreUi")
include(":featureProfile")
include(":navigation")
include(":common")
include(":featureShows")
include(":featureEpisodes")
include(":featureSeasons")
include(":featurePeoples")
include(":featureOpen")
include(":featureArticles")
include(":featureNews")
include(":featurePlayer")