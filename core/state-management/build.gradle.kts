plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "pl.nepapp.core.statemanagement"
}

dependencies {
    implementation(libs.orbit)
    implementation(libs.orbit.compose)
    implementation(libs.compose.foundation)
    implementation(libs.timber)
}