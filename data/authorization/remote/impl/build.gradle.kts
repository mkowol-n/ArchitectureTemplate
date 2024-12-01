plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.data.authorization.remote.impl"
}

dependencies {
    implementation(project(":data:authorization:remote"))

    ksp(libs.koin.compiler)
    implementation(libs.koin.annotations)

    implementation(project(":core:settings"))
    implementation(project(":core:common"))
    implementation(project(":core:config:http"))
    implementation(libs.retrofit)
}