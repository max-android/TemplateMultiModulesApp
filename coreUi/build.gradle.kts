plugins {
    alias(libs.plugins.androidLibraryPlugin)
    alias(libs.plugins.kotlinAndroidPlugin)
    alias(libs.plugins.kotlinParcelize)
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    namespace = "com.example.coreUi"
}

dependencies {
    api(project(":common"))
    api(libs.bundles.androidxDependencies)
    api(libs.bundles.composeDependencies)
    debugImplementation(libs.toolingCompose)
}