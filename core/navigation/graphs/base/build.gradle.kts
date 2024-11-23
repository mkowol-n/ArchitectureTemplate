plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.navigation.graphs.base"
}

dependencies {
    implementation(project(":core:navigation:impl"))
    implementation(project(":core:navigation:api"))
    implementation(libs.navigation.compose)
}