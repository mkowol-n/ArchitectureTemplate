plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.todolist.impl"
}

dependencies {
    implementation(project(":features:todo-details"))
    implementation(project(":features:todo-list"))
    implementation(project(":data:todo"))
}