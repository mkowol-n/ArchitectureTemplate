plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.core.navigation"
}

dependencies {
    implementation(libs.kotlin.serialization)
    implementation(libs.navigation.compose)
}