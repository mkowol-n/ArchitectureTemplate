plugins {
    id("base-android-library-conventions")
}

android {
    namespace = "pl.nepapp.core.common.impl"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:settings"))
}