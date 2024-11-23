plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.navigation.graphs"
}

dependencies {
    implementation(project(":features:login:impl"))
    implementation(project(":features:login"))
    implementation(project(":features:dashboard:impl"))
    implementation(project(":features:dashboard"))
    implementation(project(":core:navigation:impl"))
    implementation(project(":core:navigation:api"))
    implementation(libs.navigation.compose)
}