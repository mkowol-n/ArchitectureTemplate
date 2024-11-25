plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.impl"
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
    implementation(project(":core:navigation:impl"))
    implementation(project(":core:settings"))
    implementation(libs.navigation.compose)
    implementation(project(":features"))
}