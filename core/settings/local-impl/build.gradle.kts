plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.settings.localimpl"
}

dependencies {
    implementation(project(":core:settings"))
    implementation(libs.security.crypto.datastore.preferences)
}