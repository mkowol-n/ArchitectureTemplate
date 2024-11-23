plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.graphapi.impl"
}

dependencies {
    implementation(project(":features:login:impl"))
    implementation(project(":features:dashboard:impl"))
    implementation(project(":features:todo-details:impl"))
    implementation(project(":features:todo_list:impl"))
    implementation(project(":features:account:impl"))
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
    implementation(project(":features:todo-details"))
    implementation(project(":features:todo_list"))
    implementation(project(":features:account"))
    implementation(project(":core:graphapi"))
    implementation(libs.navigation.compose)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    ksp (libs.koin.compiler)
    implementation(libs.koin.annotations)
    implementation(libs.navigation.compose)
    implementation(project(":core:navigation:impl"))
    implementation(project(":core:navigation:api"))
}