plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.graphapi"
}

dependencies {
    implementation(libs.compose.foundation)
}