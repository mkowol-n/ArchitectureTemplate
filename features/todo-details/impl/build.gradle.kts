plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.tododetails.impl"
}

dependencies {
    implementation(project(":features:todo-details"))
    implementation(project(":features:login"))
}