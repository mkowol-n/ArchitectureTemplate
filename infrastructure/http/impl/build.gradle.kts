plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.infrastructure.http.impl"
}

dependencies {
    implementation(project(":data:authorization:remote"))

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.moshi)
    implementation(libs.okhttp)

    implementation(project(":core:settings"))
    implementation(project(":core:common"))
    implementation(project(":infrastructure:http"))
}