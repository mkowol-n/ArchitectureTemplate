plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.core.navigation.impl"
}

dependencies {

    implementation(project(":core:navigation"))
    implementation(libs.navigation.compose)

    implementation(libs.koin.compose)
}