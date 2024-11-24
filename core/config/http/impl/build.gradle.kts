plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.core.config.http.impl"
}

dependencies {
    implementation(project(":data:authorization:remote"))

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.moshi)
    implementation(libs.okhttp)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(project(":core:settings"))
    implementation(project(":core:common"))
    implementation(project(":core:config:http"))
}