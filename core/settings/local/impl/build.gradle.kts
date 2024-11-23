plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.settings.local.impl"
}

dependencies {
    implementation(libs.datastore)
    implementation(project(":core:settings:local"))

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)
}