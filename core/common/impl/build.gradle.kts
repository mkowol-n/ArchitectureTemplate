plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.common.impl"
}

dependencies {
    implementation(project(":core:common"))

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)

}