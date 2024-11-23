plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.navigation.graphs.maingraph"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
    implementation(project(":core:navigation:graphs:base"))
    implementation(project(":core:navigation:api"))
    implementation(libs.navigation.compose)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)
}