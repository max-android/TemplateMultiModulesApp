plugins {
    alias(libs.plugins.androidLibraryPlugin)
    alias(libs.plugins.kotlinAndroidPlugin)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.kspPlugin)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.kotlinCompose)
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
    namespace = "com.example.featureRoot"
}

dependencies {
    implementation(project("::coreUi"))
    implementation(project(":navigation"))
    implementation(project(":domain"))

    api(libs.hiltAndroid)
    ksp(libs.hiltCompiler)
    api(libs.hiltNavi)

    api(libs.navCompose)
    api(libs.navCommon)
}