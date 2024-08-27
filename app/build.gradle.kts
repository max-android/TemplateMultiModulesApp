plugins {
    alias(libs.plugins.androidApplicationPlugin)
    alias(libs.plugins.kotlinAndroidPlugin)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.kspPlugin)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.kotlinCompose)
}

android {
    namespace = "com.example.template"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.template"
        minSdk = 28
        targetSdk = 34
        versionCode = 2
        versionName = "2.0.0"
    }

    buildTypes {
        debug {

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":navigation"))
    implementation(project(":coreUi"))
    implementation(project(":featureRoot"))
    implementation(project(":featureProfile"))
    implementation(project(":featureShows"))
    implementation(project(":featureEpisodes"))
    implementation(project(":featureSeasons"))
    implementation(project(":featurePeoples"))
    implementation(project(":featureOpen"))
    implementation(project(":featureArticles"))
    implementation(project(":featureNews"))
    implementation(project(":featurePlayer"))

    implementation(libs.hiltAndroid)
    ksp(libs.hiltCompiler)
    implementation(libs.hiltNavi)

    implementation(libs.navCompose)
    implementation(libs.navCommon)
}