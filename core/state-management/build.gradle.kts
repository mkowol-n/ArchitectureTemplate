plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.statemanagement"
}

dependencies {
    implementation(libs.orbit)
    implementation(libs.orbit.compose)
}