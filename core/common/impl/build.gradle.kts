plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.common.impl"
}

dependencies {
    implementation(project(":core:common"))
}