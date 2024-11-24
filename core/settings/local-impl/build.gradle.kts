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
}