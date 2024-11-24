plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.settings.localimpl"
}

dependencies {
    implementation(libs.datastore)
    implementation(project(":core:settings"))

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)
}