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
    implementation(libs.immutableList)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.timber)
}