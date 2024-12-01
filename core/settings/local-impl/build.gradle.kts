plugins {
    id("base-android-library-conventions")
}

android {
    namespace = "pl.nepapp.core.settings.localimpl"
}

dependencies {
    implementation(project(":core:settings"))
    implementation(libs.security.crypto.datastore.preferences)
}