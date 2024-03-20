plugins {
    alias(libs.plugins.androidLibraryPlugin)
    alias(libs.plugins.kotlinAndroidPlugin)
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    namespace = "com.example.common"
}

dependencies {
    api(libs.bundles.lifecycleDependencies)
    api(libs.bundles.coroutinesDependencies)
}