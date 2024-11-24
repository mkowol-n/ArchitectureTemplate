plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.core.navigation.impl"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
    implementation(project(":features:todo-details"))
    implementation(project(":features:todo-list"))
    implementation(project(":features:account"))

    implementation(project(":features:login:impl"))
    implementation(project(":features:dashboard:impl"))
    implementation(project(":features:todo-details:impl"))
    implementation(project(":features:todo-list:impl"))
    implementation(project(":features:account:impl"))

    implementation(project(":core:navigation"))
    implementation(libs.navigation.compose)

    implementation(libs.koin.compose)
    implementation(libs.navigation.compose)
}