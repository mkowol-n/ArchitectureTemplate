plugins {
    id("base-android-library-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.core.navigation"
}

dependencies {
    implementation(libs.kotlin.serialization)
    implementation(libs.navigation.compose)
}