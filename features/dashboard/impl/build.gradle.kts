plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.dashboard.impl"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":features:todo_list"))
    implementation(project(":features:account"))
    implementation(project(":features:todo-details"))
    implementation(project(":features:dashboard"))
    implementation(project(":core:graphapi"))
}