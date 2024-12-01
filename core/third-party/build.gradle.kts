plugins {
    id("base-android-library-conventions")
}

android {
    namespace = "pl.nepapp.core.thirdparty"
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.moshi)

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)
}