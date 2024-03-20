plugins {
    alias(libs.plugins.androidLibraryPlugin)
    alias(libs.plugins.kotlinAndroidPlugin)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.kspPlugin)
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

    namespace = "com.example.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))

    api(libs.bundles.restClientDependencies)
    api(libs.bundles.moshiDependencies)
    api(libs.hiltAndroid)
    ksp(libs.hiltCompiler)
}